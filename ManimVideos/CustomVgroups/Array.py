from manim import *

class Array(VGroup):
    def __init__(self, length = 3, include_arrows = False):
        super().__init__()
        self.include_arrows = include_arrows
        self.arr = []
        self.scaled = 1
        for i in range(0, length):
            box = ArrayBox(self.include_arrows, i)
            self.arr.append(box)
            self.add(box)

    def update_boxes(self, count = 1):
        for _ in range(count):
            box = ArrayBox(self.include_arrows, len(self.arr)-1).scale(self.scaled)
            box.move_to(self.arr[len(self.arr)-1]).shift(self.scaled*2*RIGHT)
            self.arr.append(box)
        return self

    def add_boxes(self, boxes = 1):
        for box in boxes:
            self.add(box)       
        return self

    def update_scale(self, scale):
        self.scaled = scale
        return self

    def toggle_arrows(self):
        for box in self.arr:
            box.toggle_arrow()
        return self

    def color_arrows(self,color):
        for box in self.arr:
            box.color_arrow(color)
        return self

    def toggle_arrows_prop(self):
        self.include_arrows = not self.include_arrows
        for box in self.arr:
            box.include_arrows = not box.include_arrows

    def add_text_to_box_center(self,position, text, buff=0):
        text.move_to(self.arr[position].get_center()).shift(buff)
        self.add(text)
        return self
    
    def add_text_to_arrow_tip(self, position, text, buff):
        text.move_to(self.arr[position].get_tip_position()).shift(buff)
        self.add(text)
        return self

class ArrayBox(VGroup):
    def __init__(self, include_arrows = False, shift=1):
        super().__init__()
        self.include_arrows = include_arrows
        square = Square().shift(2*RIGHT*shift)
        dot = Dot().move_to(square.get_center())
        self.arrow = Arrow(start=ORIGIN, end=2.5*RIGHT).rotate(-PI/2).move_to(square.get_center()).shift(DOWN)
        self.parts = [square, dot, self.arrow]
        if(include_arrows):
            self.add(square, dot, self.arrow)
        else:
            self.add(square)

    def toggle_arrow(self):
        if(self.include_arrows):
            self.include_arrows = False
            self.remove(self.parts[1], self.parts[2])
        else:
            self.include_arrows = True
            self.add(self.parts[1], self.parts[2])
    
    def get_tip_position(self):
        return self.parts[2].get_center() \
                + self.parts[2].length_over_dim(1)*0.5*DOWN 
    
    def color_arrow(self, color):
        self.arrow.set_color(color)
        return self

class ArrayConsCells(VGroup):
    def __init__(self, length=3):
        super().__init__()
        self.scaled = 1
        cell = ConsCell().shift(3*LEFT* (length - 1))
        self.cells = [cell]
        self.add(cell)
        for _ in range(length-1):
            cell = ConsCell()
            cell.move_to(self.cells[len(self.cells)-1].get_tip_position("right")+3*RIGHT + 0.5*DOWN)
            self.cells.append(cell)
            self.add(cell)

    def update_cells(self, number):
        for _ in range(number):
            self.cells.append(ConsCell().scale(self.scaled).move_to(
                self.cells[len(self.cells)-1].get_tip_position("right")+(3*RIGHT + 0.5*DOWN)*self.scaled))
    
    def add_cells(self, cells):
        for cell in cells:
            self.add(cell)
        return self

class ConsParts(Enum):
    SQUARE_LEFT = 0
    SQUARE_RIGHT = 1
    DOT_LEFT = 2
    DOT_RIGHT = 3
    ARROW_LEFT = 4
    ARROW_RIGHT = 5

class ConsCell(VGroup):
    def __init__(self):
        super().__init__()
        square_left = Square().shift(LEFT)
        square_right = Square().shift(RIGHT)
        dot_left = Dot().move_to(square_left.get_center())
        dot_right = Dot().move_to(square_right.get_center())
        arrow_left = Arrow(start=ORIGIN, end=2.5*RIGHT).rotate(-PI/2).move_to(
            square_left.get_center()).shift(DOWN)
        arrow_right = Arrow(start=ORIGIN,end=2.5*RIGHT).move_to(
            square_right.get_center()).shift(RIGHT)
        self.parts = [square_left, square_right, dot_left, dot_right, arrow_left, arrow_right]
        for part in self.parts:
            self.add(part)
        

    def get_tip_position(self, direction):
        if direction in ["left", "Left", "down", "Down"]:
            return self.parts[ConsParts.ARROW_LEFT.value].get_center() \
                + self.parts[ConsParts.ARROW_LEFT.value].length_over_dim(1)*0.5*DOWN 
        elif direction in ["right", "Right"]:
            return self.parts[ConsParts.ARROW_RIGHT.value].get_center() \
                + self.parts[ConsParts.ARROW_RIGHT.value].length_over_dim(0)*0.5*RIGHT

