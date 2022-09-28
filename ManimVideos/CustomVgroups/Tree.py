from manim import *

class Tree(VGroup):
    def __init__(self, texts = [], positions = [], edges = []):
        super().__init__()
        self.root = Node("")
        self.nodes = {}
        self.edge_positions= []
        self.edges = []

    #datastructure methods
    def set_root(self, root):
        self.root = root
        return self

    def draw_tree(self):
        depth = self.calc_depth()
        max_width = self.get_max_width(depth)
        self.root.position_nodes()
        #self.draw_edges()
        #if depth > 4:
        #    self.scale(0.75 + 1/depth)


    def get_max_width(self, depth):
        current_max = 1
        for i in range(1, depth + 1):
            width = self.root.get_width(i)
            self.root.set_rank_width(i, width, i)
            if width > current_max:
                current_max = width 
        return current_max

    def calc_depth(self):
        return self.root.calc_depth()

    def draw_edges(self):
        self.edges = []
        for _ in range(len(self.edge_positions)):
            self.edges.append(Line(
                start=self.nodes.get(self.edge_positions[0]).get_critical_point(DOWN),
                end=self.nodes.get(self.edge_positions[1]).get_critical_point(UP)
                ))
        self.add(*self.edges)

    #manim methods
    def scale_text(self, position, scaling):
        self.nodes[position].text.scale(scaling)
        return self

    def scale_all_texts(self, scaling):
        for i in range(len(self.nodes)):
            self.scale_text(i, scaling)
        return self 

    def color_node(self, position, color):
        self.nodes[position].color_node(color)
        return self

    def update_text(self, position, text):
        self.nodes[position].update_text(text)
        return self

    def color_edges(self, color):
        for edge in self.edges:
            edge.set_color(color)
        return self 

    #for the quick tree
    def construct_default(self):
        self.nodes = [
            Node(str(i))
            for i in range(12)
        ]
        nodes = VGroup(*self.nodes).shift(3*UP)
        positions = [(0,0),(2, -4), (2, 0), (2, 4), (4, -6), (4, -3), (4, 0), (4,3), (4,6), (6,-3), (6,0), (6,3)]
        for i in range(len(positions)):
            self.nodes[i].shift(positions[i][0]*DOWN+positions[i][1]*RIGHT)
        edges = [(0,1),(0,2),(0,3), (1,4),(1,5),(2,6),(3,7), (3,8), (6,9),(6,10), (6,11)]
        self.edges = []
        for i in range(len(edges)):
            self.edges.append(Line(start=self.nodes[edges[i][0]].get_critical_point(DOWN), end=self.nodes[edges[i][1]].get_critical_point(UP)))
        self.add(*self.edges, *self.nodes)

class Node(VGroup):
    def __init__(self, text):
        super().__init__()
        self.children = []
        self.rank = 0
        self.rank_width = 0
        self.text = Text(text)
        self.rect = RoundedRectangle(width=2, height=1,color=WHITE, corner_radius=0.2)
        self.text.move_to(self.rect.get_center_of_mass())
        self.add(self.text, self.rect)

    #Helper method for building
    def __str__(self):
        return "This is node " + self.text.text + " \nChildren: " + str(self.children)

    def add_child(self, child):
        self.children.append(child)
        return self

    def set_text(self, text):
        self.remove(self.text)
        self.text = Text(str(text))
        self.add(self.text)
        return self

    #Tree methods
    def calc_depth(self):
        if self.children == []:
            return 1
        depths = []
        for i in range(len(self.children)):
            depths.append(self.children[i].calc_depth())
        return max(depths) + 1

    def get_width(self, level):
        to_sum = []
        if level == 1:
            return 1
        elif level > 1:
            for i in range(len(self.children)):
                to_sum.append(self.children[i].get_width(level - 1))
        return sum(to_sum)

    def set_rank_width(self, level, width, rank):
        if level == 1:
            self.rank_width = width 
            self.rank = rank
            return 
        elif level > 1:
            for i in range(len(self.children)):
                self.children[i].set_rank_width(level - 1, width, rank)
        return 

    #Manim methods   
    #setup
    def position_nodes(self):
        if self.rank == 1:
            self.to_edge(UP, buff = 0)  
        for i in range(len(self.children)):
            self.children[i].position_nodes()

    #animatable methods?
    def color_node(self, color):
        self.text.set_color(color)
        self.rect.set_color(color)

    def update_text(self, text):
        t = Text(text).move_to(self.rect.get_center_of_mass())
        self.remove(self.text)
        self.add(t)
        self.text = t


#Helper methods to build trees from dot
def parse_file(path):
    with open(path, "r") as f:
        data = f.readlines()
    data = [
        data[i].replace("\n", "").strip()
        for i in range(len(data))
        if data[i].__contains__("->") or data[i].__contains__("--")
    ]
    return data

def build_tree(path):
    data = parse_file(path)
    candidates = set()
    blacklist = set()
    tree_map = {}
    t = Tree()
    for i in range(len(data)):
        splitted = data[i].split("->")
        (start, end) = (int(splitted[0].strip()), int(splitted[1].strip()))
        t.edge_positions.append((start,end))
        keys = tree_map.keys()
        if end not in keys:
            tree_map.update({end : Node(str(end))})
            if start not in keys:
                tree_map.update({start : Node(str(start)).add_child(tree_map.get(end))})
            else: 
                tree_map.update({start : tree_map.get(start).add_child(tree_map.get(end))})
            if end in candidates:
                candidates.remove(end)
            blacklist.add(end)
            if start not in blacklist:
                candidates.add(start)
        else:
            tree_map.update({start : Node(str(start)).add_child(tree_map.get(end))})
            if end in candidates:
                candidates.remove(end)
            blacklist.add(end)
            if start not in blacklist:
                candidates.add(start)
    root = tree_map[list(candidates)[0]]
    t.set_root(root)
    t.nodes = tree_map
    for key in tree_map:
        t.add(tree_map.get(key))
    return t

