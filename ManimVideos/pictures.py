from manim import *
from Vgroups import StickFigure

config.background_color = WHITE


class Render(Scene):
    def construct(self):
        self.first_pic()

    def first_pic(self):
        anna_name = Text("Anna")
        anna_figure = StickFigure("29", True)
        anna_name.next_to(anna_figure, direction=DOWN)
        anna = VGroup(anna_figure, anna_name).shift(LEFT*2).scale(0.5).set_color(BLACK)

        berti_name = Text("Berti")
        berti_figure = StickFigure("56", True)
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name).next_to(anna, RIGHT).scale(0.5).set_color(BLACK)

        christo_name = Text("Christo")
        christo_figure = StickFigure("21", True)
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name).next_to(berti, RIGHT).scale(0.5).set_color(BLACK)

        demi_name = Text("Demi")
        demi_figure = StickFigure("35", True)
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name).next_to(christo, RIGHT).scale(0.5).set_color(BLACK)

        ernesto_name = Text("Ernesto")
        ernesto_figure = StickFigure("47", True)
        ernesto_name.next_to(ernesto_figure, direction=DOWN)


        arr = Arrow(start = [0,0,0], end=[3,0,0]).rotate(PI).set_color(BLACK).next_to(anna, LEFT)
        text_vorne = Text("vorneEntfernen()").set_color(BLACK).scale(0.5)
        text_vorne2 = Text("pop()").set_color(BLACK).scale(0.5)
        text = VGroup(text_vorne, text_vorne).arrange(DOWN)
        text.next_to(arr, DOWN)

        arr2 = arr.copy().next_to(demi, RIGHT)
        ernesto = VGroup(ernesto_figure, ernesto_name).next_to(arr2, RIGHT, buff=0).set_color(BLACK).scale(0.5)
        text_h = VGroup(Text("hintenAnfügen()").set_color(BLACK).scale(0.5), 
        Text("push()").scale(0.5).set_color(BLACK)).arrange(DOWN).next_to(arr2, DOWN)

        everything = VGroup(anna, berti, christo, demi, arr, text_vorne, arr2, text_h, ernesto).shift(1.5*LEFT)
        self.add(everything)
        

