from manim import *
from Vgroups import Arr, StickFigure

class MyListArrayAppendSorted(Scene):
    def construct(self):
        arr = Arr(3, False).scale(0.75).move_to(ORIGIN)
        arr.scaled = 0.75

        anna_name = Text("Anna")
        anna_figure = StickFigure("29", True)
        anna_name.next_to(anna_figure, direction=DOWN)
        anna = VGroup(anna_figure, anna_name).move_to(ORIGIN).to_edge(LEFT).scale(0.5)

        berti_name = Text("Berti")
        berti_figure = StickFigure("17", True)
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name).move_to(ORIGIN).to_edge(LEFT).scale(0.5)

        christo_name = Text("Christo")
        christo_figure = StickFigure("21", True)
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name).move_to(ORIGIN).to_edge(LEFT).scale(0.5)

        demi_name = Text("Demi")
        demi_figure = StickFigure("15", True)
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name).move_to(ORIGIN).to_edge(LEFT).scale(0.5)

        append_anna_text = Text("myList.appendSorted(new Human(\"Anna\", 29));",
         t2c={"myList":BLUE_B, "appendSorted": YELLOW_B, "Human": GREEN_E, "new": PURPLE_B}).scale(0.5).to_corner(UL)
        append_berti_text = Text("myList.appendSorted(new Human(\"Berti\", 17));",
         t2c={"myList":BLUE_B, "appendSorted": YELLOW_B, "Human": GREEN_E, "new": PURPLE_B}).scale(0.5).to_corner(UL)
        append_christo_text = Text("myList.appendSorted(new Human(\"Christo\", 21));",
         t2c={"myList":BLUE_B, "appendSorted": YELLOW_B, "Human": GREEN_E, "new": PURPLE_B}).scale(0.5).to_corner(UL)
        append_demi_text = Text("myList.appendSorted(new Human(\"Demi\", 15));",
         t2c={"myList":BLUE_B, "appendSorted": YELLOW_B, "Human": GREEN_E, "new": PURPLE_B}).scale(0.5).to_corner(UL)

        bubble_sort_text = Text("BUBBLESORT", t2c={"B":RED, "U":YELLOW, "L": BLUE,
         "E": GREEN, "S": YELLOW, "O": YELLOW, "R": BLUE, "T": PURPLE}).scale(0.75).to_corner(UR)

        self.play(FadeIn(arr))
        self.wait()
        self.play(Write(append_anna_text), FadeIn(anna))
        self.wait()
        self.play(anna.animate.move_to(arr.arr[0].get_center()).scale(0.5))
        self.wait()
        self.play(FadeOut(append_anna_text))
        self.wait()
        self.play(Write(append_berti_text), FadeIn(berti))
        self.wait()
        self.play(berti.animate.move_to(arr.arr[1].get_center()).scale(0.5))
        self.wait()
        self.play(FadeIn(bubble_sort_text))
        self.play(Swap(anna, berti))
        self.wait()
        self.play(FadeOut(append_berti_text, bubble_sort_text))
        self.wait()
        self.play(Write(append_christo_text), FadeIn(christo))
        self.wait()
        self.play(christo.animate.move_to(arr.arr[2].get_center()).scale(0.5))
        self.wait()
        self.play(FadeIn(bubble_sort_text))
        self.play(Swap(anna, christo))
        self.wait()
        arr.update_boxes(3)
        peeps = VGroup(anna, berti, christo)
        self.play(arr.animate.add_boxes(arr.arr).shift(2*LEFT), FadeOut(append_christo_text), peeps.animate.shift(2*LEFT))
        self.wait()
        self.play(FadeIn(demi), Write(append_demi_text))
        self.wait()
        self.play(demi.animate.move_to(arr.arr[3].get_center()).scale(0.5))
        self.wait()
        self.play(Swap(demi, anna))
        self.play(Swap(demi, christo))
        self.play(Swap(demi, berti))
        self.wait()


