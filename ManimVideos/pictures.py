from manim import *
from Vgroups import StickFigure, Arr

config.background_color = WHITE


class Render(Scene):
    def construct(self):
        self.build_content()
        self.fourth_pic()

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
        
        for figure in self.stick_figures:
            figure.set_color(BLACK).scale(0.5)
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

        self.arr = Arr(3, False).set_color(BLACK).shift(2*LEFT)