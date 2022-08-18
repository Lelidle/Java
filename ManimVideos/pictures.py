from manim import *
from Vgroups import StickFigure, Arr, Bubble

config.background_color = WHITE


class Render(Scene):
    def construct(self):
        self.build_content()
        self.ninth_pic()

    def ninth_pic(self):
        arr = Arr(1, False).shift(4*LEFT).set_color(BLACK)
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
        arr = Arr(1, False).shift(4*LEFT).set_color(BLACK)
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
        arr = Arr(1, False).shift(4*LEFT).set_color(BLACK)
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
        arr = Arr(3, True).set_color(BLACK).shift(2*LEFT)
        for i in range(3):
            arr.add_text_to_arrow_tip(i, Text("null").scale(0.5).set_color(BLACK), 0.4*DOWN)
        for i in range(3):
            arr.add_text_to_box_center(i, Text("humans[" + str(i) + "]").scale(0.4).set_color(BLACK),
             0.8*UP)
        arrow = Arrow(start=[0,0,0], end=[2,0,0]).next_to(self.arr, LEFT).set_color(BLACK)
        text2 = Text("humans").next_to(arrow, LEFT, buff=0).set_color(BLACK).scale(0.5).shift(RIGHT*0.4)
        self.add(arrow, arr, text2)

    def fifth_pic(self):
        arr = Arr(3, True).set_color(BLACK).shift(2*LEFT)
        for i in range(3):
            arr.add_text_to_arrow_tip(i, self.stick_figures[i].scale(0.5), 0.9*DOWN)
        for i in range(3):
            arr.add_text_to_box_center(i, Text("humans[" + str(i) + "]").scale(0.4).set_color(BLACK),
             0.8*UP)
        arrow = Arrow(start=[0,0,0], end=[2,0,0]).next_to(self.arr, LEFT).set_color(BLACK)
        text2 = Text("humans").next_to(arrow, LEFT, buff=0).set_color(BLACK).scale(0.5).shift(RIGHT*0.4)
        self.add(arrow, arr, text2)

    def fourth_pic(self):
        arr = Arr(3, True)
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

        self.arr = Arr(3, False).set_color(BLACK).shift(2*LEFT)