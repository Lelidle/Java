from manim import *

from CustomVgroups.StickFigure import StickFigure
from CustomVgroups.Card import Card 
from CustomVgroups.Bubble import Bubble
from CustomVgroups.Array import Array
from CustomVgroups.Tree import Tree, Node, build_tree

config.background_color = WHITE

class Render(Scene):
    def construct(self):
        #self.build_content()
        self.test()


    def test(self):
        t = build_tree("Dot/test.dot").set_color(BLACK)
        t.position_tree()
        self.add(t, NumberPlane())

    def simple_tree(self):
        t = Tree().set_color(BLACK)
        texts = ["root", "inner node", "inner node", "inner node", "leaf", "leaf", "inner node", "leaf", "leaf", "leaf", "leaf", "leaf"]
        colors = [RED_E, BLUE_E, BLUE_E, BLUE_E, GREEN_E, GREEN_E, BLUE_E, GREEN_E,GREEN_E,GREEN_E,GREEN_E,GREEN_E]
        t.color_lines(GREEN_D)
        for i in range(12):
            t.update_text(i, texts[i])
            t.color_node(i, colors[i])
        t.scale_all_texts(0.5)
        self.add(t)


    def stack_push_pop(self):
        rectgroup = VGroup()
        rects = []
        for i in range(1):
            r = Rectangle(width=2, height=1).shift(i*UP)
            rects.append(r)
            rectgroup.add(r)

        r1 = Rectangle(width=2, height=1, fill_opacity = 0.25).set_color(YELLOW_E).to_edge(LEFT).shift(DOWN)
        end = Text("EndNode").set_color(YELLOW_E).scale(0.3).move_to(r1.get_critical_point(ORIGIN))
        text1 = Text("push(djego)").set_color(BLACK).scale(0.3).next_to(r1, DOWN)

        r2 = []
        r2_group = VGroup()
        for i in range(2):
            r = Rectangle(width=2, height=1, fill_opacity=0.25)
            if(i==0): r.next_to(r1, RIGHT)
            else: r.move_to(r2[0].get_critical_point(ORIGIN)).shift(i*UP)
            r2.append(r)
            r2_group.add(r)
        r2[0].set_color(YELLOW_E)
        r2[1].set_color(RED_E)
        end2 = end.copy().move_to(r2[0].get_critical_point(ORIGIN))
        text2 = Text("push(miriam)").set_color(BLACK).scale(0.3).next_to(r2_group, DOWN) 
        djego = Text("djego").set_color(RED_E).scale(0.3).move_to(r2[1].get_critical_point(ORIGIN))

        r3 = []
        r3_group = VGroup()
        for i in range(3):
            r = Rectangle(width=2, height=1, fill_opacity=0.25)
            if(i==0): r.next_to(r2[0], RIGHT)
            else: r.move_to(r3[0].get_critical_point(ORIGIN)).shift(i*UP)
            r3.append(r)
            r3_group.add(r)
        r3[0].set_color(YELLOW_E)
        r3[1].set_color(RED_E)
        r3[2].set_color(GREEN_E)
        end3 = end.copy().move_to(r3[0].get_critical_point(ORIGIN))
        text3 = Text("pop()").set_color(BLACK).scale(0.3).next_to(r3_group, DOWN) 
        djego2 = Text("djego").set_color(RED_E).scale(0.3).move_to(r3[1].get_critical_point(ORIGIN))
        miriam = Text("miriam").set_color(GREEN_E).scale(0.3).move_to(r3[2].get_critical_point(ORIGIN))
        
        r4 = []
        r4_group = VGroup()
        for i in range(2):
            r = Rectangle(width=2, height=1, fill_opacity=0.25)
            if(i==0): r.next_to(r3[0], RIGHT)
            else: r.move_to(r4[0].get_critical_point(ORIGIN)).shift(i*UP)
            r4.append(r)
            r4_group.add(r)
        r4[0].set_color(YELLOW_E)
        r4[1].set_color(RED_E)
        end4 = end.copy().move_to(r4[0].get_critical_point(ORIGIN))
        text4 = Text("push(walter)").set_color(BLACK).scale(0.3).next_to(r4_group, DOWN) 
        djego3 = Text("djego").set_color(RED_E).scale(0.3).move_to(r4[1].get_critical_point(ORIGIN))

        r5 = []
        r5_group = VGroup()
        for i in range(3):
            r = Rectangle(width=2, height=1, fill_opacity=0.25)
            if(i==0): r.next_to(r4[0], RIGHT)
            else: r.move_to(r5[0].get_critical_point(ORIGIN)).shift(i*UP)
            r5.append(r)
            r5_group.add(r)
        r5[0].set_color(YELLOW_E)
        r5[1].set_color(RED_E)
        r5[2].set_color(BLUE_E)
        end5 = end.copy().move_to(r5[0].get_critical_point(ORIGIN))
        text5 = Text("pop()").set_color(BLACK).scale(0.3).next_to(r5_group, DOWN) 
        djego4 = Text("djego").set_color(RED_E).scale(0.3).move_to(r5[1].get_critical_point(ORIGIN))
        walter = Text("walter").set_color(BLUE_E).scale(0.3).move_to(r5[2].get_critical_point(ORIGIN))
        
        r6 = []
        r6_group = VGroup()
        for i in range(2):
            r = Rectangle(width=2, height=1, fill_opacity=0.25)
            if(i==0): r.next_to(r5[0], RIGHT)
            else: r.move_to(r6[0].get_critical_point(ORIGIN)).shift(i*UP)
            r6.append(r)
            r6_group.add(r)
        r6[0].set_color(YELLOW_E)
        r6[1].set_color(RED_E)
        end6 = end.copy().move_to(r6[0].get_critical_point(ORIGIN))
        djego5 = Text("djego").set_color(RED_E).scale(0.3).move_to(r6[1].get_critical_point(ORIGIN))
        #walter = Text("walter").set_color(BLUE_E).scale(0.3).move_to(r5[2].get_critical_point(ORIGIN))


        self.add(r1, end, text1, r2_group, end2, text2, djego, r3_group, end3, text3, djego2, miriam, r4_group, end4, text4, djego3, r5_group, end5, text5, djego4, walter, r6_group, end6, djego5)
        


    def string_in_memory(self):
        memory = VGroup()
        rect = RoundedRectangle(corner_radius=0.5, height=7,width=12, fill_opacity=1).set_color(GRAY).set_stroke(BLACK)
        mem = Text("Memory").set_color(GREY_A).scale(0.4).next_to(rect.get_critical_point(UL)).shift(DOWN*0.3)
        memory.add(rect, mem)
        x = Text("x").set_color(BLACK).shift(LEFT*7.5+1.5*UP)
        arrow = Arrow(start=ORIGIN, end=[3,0,0]).set_color(BLACK).next_to(x, RIGHT)
        card = Card(_width = 8, text=Text("s1: String"), attributes=[Text("value = <adress>")]).scale(0.7).set_color(BLACK).next_to(arrow,RIGHT)
        x_set = VGroup(x, arrow, card).scale(0.5)
        arrow2 = Arrow(start=ORIGIN, end=[3,1.5,0]).set_color(GREEN).next_to(card, RIGHT).shift(0.5*UP+0.5*LEFT)
        arr = Array(5, False).add_text_to_box_center(0, Text("H")).add_text_to_box_center(1, Text("a")).add_text_to_box_center(2, Text("l")).add_text_to_box_center(3, Text("l")).add_text_to_box_center(4, Text("o")).set_color(GREEN).scale(0.4).next_to(arrow2, RIGHT).shift(UP*0.5)
        x_set.add(arrow2,arr)
        y = Text("y").set_color(BLACK).next_to(card, DOWN).shift(1.5*DOWN)
        arrow3 = Arrow(start=ORIGIN, end=[0,3,0]).set_color(BLACK).next_to(y, UP)
        y_set = VGroup(y, arrow3).scale(0.5).shift(DOWN*0.4)

        z = Text("z").set_color(BLACK).shift(LEFT*7.5+1.5*DOWN)
        arrow4 = Arrow(start=ORIGIN, end=[3,0,0]).set_color(BLACK).next_to(z, RIGHT)
        card2 = Card(_width = 8, text=Text("s2: String"), attributes=[Text("value = <adress>")]).scale(0.7).set_color(BLACK).next_to(arrow4,RIGHT)
        z_set = VGroup(z,arrow4,card2).scale(0.5)
        arrow5 = Arrow(start=ORIGIN, end=[3,1.5,0]).set_color(GREEN).next_to(card2, RIGHT).shift(0.5*UP+0.5*LEFT)
        arr2 = Array(5, False).add_text_to_box_center(0, Text("H")).add_text_to_box_center(1, Text("a")).add_text_to_box_center(2, Text("l")).add_text_to_box_center(3, Text("l")).add_text_to_box_center(4, Text("o")).set_color(GREEN).scale(0.4).next_to(arrow5, RIGHT).shift(UP*0.5)
        z_set.add(arr2,arrow5)

        self.add(memory, x_set, y_set, z_set)


    def linked_move_to_back(self):
        text = Text("moveToBack()").scale(0.6).to_corner(UL).set_color(BLACK)
        arr = Array(1, False).shift(4*LEFT).set_color(BLACK)
        arr.add_text_to_box_center(0,Text("Warteschlange").scale(0.4).set_color(BLACK), 0*DOWN)
        arrows = VGroup()
        for _ in range(3):
            arrows.add(Arrow(start=ORIGIN, end=[2,0,0]).next_to(arr, RIGHT).set_color(BLACK))
        self.stick_figures[0].next_to(arrows[0], RIGHT)
        arrows[1].next_to(self.stick_figures[0], RIGHT)
        self.stick_figures[1].next_to(arrows[1], RIGHT)
        arrows[2].next_to(self.stick_figures[1], RIGHT)
        nullo = Text("null").scale(0.4).set_color(BLACK).next_to(arrows[2])
        successor = Text("Nachfolger").scale(0.4).next_to(arrows[1], UP).set_color(RED)
        successor2 = Text("Nachfolger").scale(0.4).next_to(arrows[2], UP).set_color(RED)
        carrow = CurvedArrow(start_point=[-3,1,0], end_point=[2,1,0], radius=-4).set_color(GREEN)
        carrow2 = CurvedArrow(start_point=ORIGIN, end_point = [2,0,0], radius=-2).next_to(arr, UP).set_color(BLACK).shift(1.5*LEFT+0.1*DOWN)
        carrow3 = Arrow(start=[3,2.2,0], end = ORIGIN).next_to(arr, DOWN).set_color(BLACK).shift(1.5*RIGHT)
        bubble = Bubble().set_color(BLACK).next_to(carrow2, UP).scale(0.5).add_text_to_bubble(Text("pop()").scale(0.4).set_color(BLACK),
        0.05*RIGHT+0.05*UP).shift(RIGHT*0.5+DOWN*0.6)
        root = Text("root (Wurzel)").scale(0.4).next_to(carrow, UP).set_color(GREEN)
        line1 = Line(start=[1,0,0], end=[0,1,0]).set_color(RED).move_to(arrows[1].get_critical_point(ORIGIN))
        line2 = Line(start=[0,0,0], end=[1,1,0]).set_color(RED).move_to(arrows[1].get_critical_point(ORIGIN))
        first = VGroup(arr, arrows[1], text, arrows[2], root, self.stick_figures[0], self.stick_figures[1],
        carrow, nullo, successor, successor2, carrow2,carrow3, bubble, line1, line2).shift(UP).scale(0.75)
        arr2 = arr.copy().to_edge(DOWN).next_to(arr, DOWN).shift(1.5*DOWN)
        bubble2 = Bubble().set_color(BLACK).next_to(carrow3, LEFT).scale(0.5).add_text_to_bubble(Text("push(Anna)").scale(0.3).set_color(BLACK),
        0.05*LEFT+0.05*UP).flip_bubble().shift(1.2*RIGHT+0.2*UP)
        arrow3 =arrows[1].copy().next_to(arr2, RIGHT).set_color(GREEN)
        berti2 = self.stick_figures[1].copy().next_to(arrow3, RIGHT)
        arrow4 = arrows[1].copy().next_to(berti2, RIGHT)
        anna2 = self.stick_figures[0].copy().next_to(arrow4, RIGHT)
        arrow5 = arrows[1].copy().next_to(anna2, RIGHT)
        nullo2 = nullo.copy().next_to(arrow5, RIGHT)
        successor3 = successor.copy().next_to(arrow5, UP)
        successor4 = successor2.copy().next_to(arrow4, UP)
        root2 = root.copy().next_to(arrow3, UP).scale(0.8)
        second = VGroup(arr2, bubble2, arrow3, berti2, successor3, successor4, arrow4, anna2, arrow5, nullo2, root2)
        self.add(first, second)

    def linked_pop(self):
        arr = Array(1, False).shift(4*LEFT).set_color(BLACK)
        arr.add_text_to_box_center(0,Text("Warteschlange").scale(0.4).set_color(BLACK), 0*DOWN)
        arrows = VGroup()
        for _ in range(3):
            arrows.add(Arrow(start=ORIGIN, end=[2,0,0]).next_to(arr, RIGHT).set_color(BLACK))
        self.stick_figures[0].next_to(arrows[0], RIGHT)
        arrows[1].next_to(self.stick_figures[0], RIGHT)
        self.stick_figures[1].next_to(arrows[1], RIGHT)
        arrows[2].next_to(self.stick_figures[1], RIGHT)
        nullo = Text("null").scale(0.4).set_color(BLACK).next_to(arrows[2])
        successor = Text("Nachfolger").scale(0.4).next_to(arrows[1], UP).set_color(RED)
        successor2 = Text("Nachfolger").scale(0.4).next_to(arrows[2], UP).set_color(RED)
        carrow = CurvedArrow(start_point=[-3,1,0], end_point=[2,1,0], radius=-4).set_color(GREEN)
        carrow2 = CurvedArrow(start_point=ORIGIN, end_point = [2,0,0], radius=-2).next_to(arr, UP).set_color(BLACK).shift(1.5*LEFT+0.1*DOWN)
        bubble = Bubble().set_color(BLACK).next_to(carrow2, UP).scale(0.5).add_text_to_bubble(Text("pop()").scale(0.4).set_color(BLACK),
        0.05*RIGHT+0.05*UP).shift(RIGHT*0.5+DOWN*0.6)
        root = Text("root (Wurzel)").scale(0.4).next_to(carrow, UP).set_color(GREEN)
        carrow3 = CurvedArrow(start_point=[5.5,0,0], end_point = ORIGIN, radius=-5).next_to(arr, DOWN).set_color(BLACK).shift(0.1*RIGHT)
        line1 = Line(start=[1,0,0], end=[0,1,0]).set_color(RED).move_to(arrows[1].get_critical_point(ORIGIN))
        line2 = Line(start=[0,0,0], end=[1,1,0]).set_color(RED).move_to(arrows[1].get_critical_point(ORIGIN))
        self.add(arr, arrows[1], arrows[2], root, self.stick_figures[0], self.stick_figures[1],
        carrow, nullo, successor, successor2, carrow2, bubble, carrow3, line1, line2)

    def eigth_pic(self):
        arr = Array(1, False).shift(4*LEFT).set_color(BLACK)
        arr.add_text_to_box_center(0,Text("Warteschlange").scale(0.4).set_color(BLACK), 0*DOWN)
        arrows = VGroup()
        for _ in range(3):
            arrows.add(Arrow(start=ORIGIN, end=[2,0,0]).next_to(arr, RIGHT).set_color(BLACK))
        root = Text("root (Wurzel)").scale(0.4).next_to(arrows[0], UP).set_color(RED)
        self.stick_figures[0].next_to(arrows[0], RIGHT)
        arrows[1].next_to(self.stick_figures[0], RIGHT)
        self.stick_figures[1].next_to(arrows[1], RIGHT)
        arrows[2].next_to(self.stick_figures[1], RIGHT)
        nullo = Text("null").scale(0.4).set_color(BLACK).next_to(arrows[2])
        successor = Text("Nachfolger").scale(0.4).next_to(arrows[1], UP).set_color(RED)
        successor2 = Text("Nachfolger").scale(0.4).next_to(arrows[2], UP).set_color(RED)
        carrow = CurvedArrow(start_point=ORIGIN, end_point = [2,0,0], radius=-2).next_to(root, UP).set_color(BLACK).shift(0.4*UP)
        carrow2 = CurvedArrow(start_point=ORIGIN, end_point = [2,0,0], radius=-2).next_to(successor, UP).set_color(BLACK).shift(0.4*UP)
        bubble = Bubble().set_color(BLACK).next_to(carrow, UP).scale(0.5).add_text_to_bubble(Text("Länge?").scale(0.4).set_color(BLACK),
        0.05*RIGHT+0.05*UP).shift(RIGHT*0.5+DOWN*0.6)
        bubble2 = Bubble().set_color(BLACK).next_to(carrow2, UP).scale(0.5).add_text_to_bubble(Text("Länge?").scale(0.4).set_color(BLACK),
        0.05*RIGHT+0.05*UP).shift(RIGHT*0.5+DOWN*0.6)
        carrow3 = CurvedArrow(start_point=[1.8,0,0], end_point = ORIGIN, radius=-1.5).next_to(arrows[1], UP).set_color(BLACK).shift(2*DOWN)
        carrow4 = CurvedArrow(start_point=[1.8,0,0], end_point = ORIGIN, radius=-1.5).next_to(arrows[0], UP).set_color(BLACK).shift(2*DOWN)
        one = Text("1").scale(0.6).set_color(BLACK).next_to(carrow3, DOWN)
        two = Text("2").scale(0.8).set_color(BLACK).next_to(carrow4, DOWN)
        carrow5 = CurvedArrow(start_point=ORIGIN, end_point = [2,0,0], radius=-2).next_to(arr, UP).set_color(BLACK).shift(1.5*LEFT+0.1*UP)
        bubble3 = Bubble().set_color(BLACK).next_to(carrow5, UP).scale(0.5).add_text_to_bubble(Text("Länge?").scale(0.4).set_color(BLACK),
        0.05*RIGHT+0.05*UP).shift(RIGHT*0.5+DOWN*0.6)
        carrow6 = CurvedArrow(start_point=[1.8,0,0], end_point = ORIGIN, radius=-1.5).next_to(arr, DOWN).set_color(BLACK).shift(1.5*LEFT)
        two2 = Text("2").scale(0.8).set_color(BLACK).next_to(carrow6, DOWN)        
        self.add(arr,arrows, root, self.stick_figures[0], self.stick_figures[1], carrow5, bubble3, carrow6, two2,
         nullo, successor, successor2, carrow, bubble, carrow2, bubble, carrow3, carrow4, bubble2, one, two)


    def seventh_pic(self):
        arr = Array(1, False).shift(4*LEFT).set_color(BLACK)
        arr.add_text_to_box_center(0,Text("Warteschlange").scale(0.4).set_color(BLACK), 0*DOWN)
        arrows = VGroup()
        for _ in range(3):
            arrows.add(Arrow(start=ORIGIN, end=[2,0,0]).next_to(arr, RIGHT).set_color(BLACK))
        root = Text("root (Wurzel)").scale(0.3).next_to(arrows[0], UP).set_color(RED)
        self.stick_figures[0].next_to(arrows[0], RIGHT)
        arrows[1].next_to(self.stick_figures[0], RIGHT)
        self.stick_figures[1].next_to(arrows[1], RIGHT)
        arrows[2].next_to(self.stick_figures[1], RIGHT)
        nullo = Text("null").scale(0.4).set_color(BLACK).next_to(arrows[2])
        successor = Text("Nachfolger").scale(0.3).next_to(arrows[1], UP).set_color(RED)
        successor2 = Text("Nachfolger").scale(0.3).next_to(arrows[2], UP).set_color(RED)
        self.add(arr,arrows, root, self.stick_figures[0], self.stick_figures[1], nullo, successor, successor2)

    def sixth_pic(self):
        arr = Array(3, False).set_color(BLACK).shift(2*LEFT)
        for i in range(3):
            arr.add_text_to_box_center(i, Text("humans[" + str(i) + "] \n        null").scale(0.4).set_color(BLACK),
             0)
        arrow = Arrow(start=[0,0,0], end=[2,0,0]).next_to(self.arr, LEFT).set_color(BLACK)
        text2 = Text("humans").next_to(arrow, LEFT, buff=0).set_color(BLACK).scale(0.5).shift(RIGHT*0.4)
        self.add(arrow, arr, text2)

    def fifth_pic(self):
        arr = Array(3, True).set_color(BLACK).shift(2*LEFT)
        for i in range(3):
            arr.add_text_to_arrow_tip(i, self.stick_figures[i].scale(0.5), 0.9*DOWN)
        for i in range(3):
            arr.add_text_to_box_center(i, Text("humans[" + str(i) + "]").scale(0.4).set_color(BLACK),
             0.8*UP)
        arrow = Arrow(start=[0,0,0], end=[2,0,0]).next_to(self.arr, LEFT).set_color(BLACK)
        text2 = Text("humans").next_to(arrow, LEFT, buff=0).set_color(BLACK).scale(0.5).shift(RIGHT*0.4)
        self.add(arrow, arr, text2)

    def fourth_pic(self):
        arr = Array(3, True)
        arr.set_color(BLACK).shift(2*LEFT)
        arrow = Arrow(start=[0,0,0], end=[2,0,0]).next_to(self.arr, LEFT).set_color(BLACK)
        for i in range(0,3):
            arr.add_text_to_arrow_tip(i, Text("0").set_color(BLACK).scale(2), 0.5)
        text2 = Text("array").next_to(arrow, LEFT).set_color(BLACK)
        self.add(arrow, arr, text2)

    def third_pic(self):
        for i in range(0,3):
            self.arr.add_text_to_box_center(i, Text("0").set_color(BLACK).scale(2))
        self.add(self.arr)

    def second_pic(self):
        self.add(self.arr)

    def first_pic(self):
    
        self.anna.shift(LEFT*2)
        self.berti.next_to(self.anna, RIGHT)
        self.christo.next_to(self.berti, RIGHT)
        self.demi.next_to(self.christo, RIGHT)

        arr = Arrow(start = [0,0,0], end=[3,0,0]).rotate(PI).set_color(BLACK).next_to(self.anna, LEFT)
        text = VGroup(Text("vorneEntfernen()").set_color(BLACK).scale(0.5), Text("pop()").set_color(BLACK).scale(0.5)).arrange(DOWN)
        text.next_to(arr, DOWN)

        arr2 = arr.copy().next_to(self.demi, RIGHT)
        self.ernesto.next_to(arr2, RIGHT, buff=0).set_color(BLACK)
        text_hinten = VGroup(Text("hintenAnfügen()").set_color(BLACK).scale(0.5), 
        Text("push()").scale(0.5).set_color(BLACK)).arrange(DOWN).next_to(arr2, DOWN)

        everything = VGroup(self.anna, self.berti, self.christo, self.demi, self.ernesto, arr, text, arr2, text_hinten).shift(0.5*LEFT)
        self.add(everything)


    def build_content(self):
        anna_name = Text("Anna")
        anna_figure = StickFigure("29", True)
        anna_name.next_to(anna_figure, direction=DOWN)
        self.anna = VGroup(anna_figure, anna_name)

        berti_name = Text("Berti")
        berti_figure = StickFigure("56", True)
        berti_name.next_to(berti_figure, direction = DOWN)
        self.berti = VGroup(berti_figure, berti_name)

        christo_name = Text("Christo")
        christo_figure = StickFigure("21", True)
        christo_name.next_to(christo_figure, direction=DOWN)
        self.christo = VGroup(christo_figure, christo_name)

        demi_name = Text("Demi")
        demi_figure = StickFigure("35", True)
        demi_name.next_to(demi_figure, direction=DOWN)
        self.demi = VGroup(demi_figure, demi_name)

        ernesto_name = Text("Ernesto")
        ernesto_figure = StickFigure("47", True)
        ernesto_name.next_to(ernesto_figure, direction=DOWN)
        self.ernesto = VGroup(ernesto_figure, ernesto_name)

        self.stick_figures = [self.anna, self.berti, self.christo, self.demi, self.ernesto]
        for figure in self.stick_figures:
            figure.set_color(BLACK).scale(0.5)

        self.arr = Array(3, False).set_color(BLACK).shift(2*LEFT)