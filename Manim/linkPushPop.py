from msilib.schema import Directory
from manim import *
from Vgroups import StickFigure

class MyListLinkedPushPop(Scene):
    def construct(self):
        root_text = Text("root", t2c={"root": BLUE_B}).scale(0.5)
        root_arrow = Arrow(start=ORIGIN, end= RIGHT*1.5).next_to(root_text,direction=RIGHT, buff=0.1)
        root = VGroup(root_text, root_arrow).to_edge(LEFT).shift(DOWN*0.5)

        compositum_text = Text("We assume our implementation uses the compositum pattern with an EndNode").scale(0.5).to_corner(UL)
        end_node_text = Text("endNode", t2c={"endNode": BLUE_B}).scale(0.5).next_to(root_arrow, direction=RIGHT, buff=0.1)

        new_list_text = Text("MyListLinked myList = new MyListLinked();",
        t2c={"MyListLinked":GREEN_E, "myList":BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_anna_text = Text("Human anna = new Human(\"Anna\", 29);",
        t2c={"Human":GREEN_E, "anna": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_berti_text = Text("Human berti = new Human(\"Berti\", 56);",
        t2c={"Human":GREEN_E, "berti": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_christo_text = Text("Human christo = new Human(\"Christo\", 21);",
        t2c={"Human":GREEN_E, "christo": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL).shift(0.5*DOWN)
        new_demi_text = Text("Human demi = new Human(\"Demi\", 35);",
        t2c={"Human":GREEN_E, "demi": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL).shift(1*DOWN)
        push_text_anna = Text("myList.push(anna);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "anna": BLUE_B}).scale(0.5).to_corner(UL)
        push_text_berti = Text("myList.push(berti);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "berti": BLUE_B}).scale(0.5).to_corner(UL)
        push_text_christo = Text("myList.push(christo);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "christo": BLUE_B}).scale(0.5).to_corner(UL).shift(0.5*DOWN)
        push_text_demi = Text("myList.push(demi);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "demi": BLUE_B}).scale(0.5).to_corner(UL).shift(1*DOWN)
        pop_text = Text("myList.pop();", t2c={"myList": BLUE_B, "pop": YELLOW_B}).scale(0.5).to_corner(UL)

        anna_name = Text("Anna").scale(0.3)
        berti_name = Text("Berti").scale(0.3)
        christo_name = Text("Christo").scale(0.3)
        demi_name = Text("Demi").scale(0.3)

        anna_figure = StickFigure("29", True).scale(0.3).shift(LEFT*6+UP*1.5)
        anna_figure.scaled = 0.3
        anna_name.next_to(anna_figure, direction=DOWN)
        anna = VGroup(anna_figure, anna_name)

        berti_figure = StickFigure("56", True).scale(0.3).shift(LEFT*6+UP*1.5)
        berti_figure.scaled = 0.3
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name)

        christo_figure = StickFigure("21", True).scale(0.3).shift(LEFT*6+ UP*1.5)
        christo_figure.scaled = 0.3
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name)

        demi_figure = StickFigure("35", True).scale(0.3).shift(LEFT*6+UP*1.5)
        demi_figure.scaled = 0.3
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name)

        self.play(Write(new_list_text))
        self.wait()
        self.play(FadeIn(root))
        self.play(Unwrite(new_list_text))
        self.wait()
        self.play(Write(compositum_text), FadeIn(end_node_text))
        self.wait()
        self.play(Unwrite(compositum_text))
        self.play(Write(new_anna_text))
        self.play(FadeIn(anna))
        self.wait()
        self.play(Unwrite(new_anna_text))
        self.play(Write(push_text_anna))
        self.wait()
        self.play(
            anna.animate.next_to(root_arrow, direction=RIGHT, buff=0.1).shift(DOWN*0.25),
            end_node_text.animate.shift(1*RIGHT)
        )
        self.play(anna_figure.animate.raise_arm("right"))
        self.wait()
        self.play(Unwrite(push_text_anna))
        self.play(Write(new_berti_text), Write(new_christo_text), Write(new_demi_text))
        self.wait()
        self.play(FadeIn(berti))
        self.wait()
        self.play(FadeOut(new_berti_text, new_christo_text, new_demi_text))
        self.wait()
        self.play(Write(push_text_berti), Write(push_text_christo), Write(push_text_demi))
        self.wait()
        self.play(berti.animate.shift(1.5*RIGHT))
        self.play(
            berti.animate.next_to(anna, direction=RIGHT, buff=0.5),
            end_node_text.animate.shift(1*RIGHT)
        )
        self.play(berti_figure.animate.raise_arm("right"))
        self.play(FadeIn(christo))
        self.wait()
        self.play(christo.animate.shift(1.5*RIGHT))
        self.play(christo.animate.shift(1.1*RIGHT))
        self.play(
            christo.animate.next_to(berti, direction=RIGHT, buff=0.5),
            end_node_text.animate.shift(1*RIGHT)
        )
        self.play(christo_figure.animate.raise_arm("right"))
        self.wait()
        self.play(FadeIn(demi))
        self.play(demi.animate.shift(1.5*RIGHT))
        self.play(demi.animate.shift(1.1*RIGHT))
        self.play(demi.animate.shift(1.1*RIGHT))
        self.play(
            demi.animate.next_to(christo, direction=RIGHT, buff=0.5),
            end_node_text.animate.shift(1*RIGHT)
        )
        self.play(demi_figure.animate.raise_arm("right"))
        self.wait()
        self.play(FadeOut(push_text_berti, push_text_christo, push_text_demi))
        self.wait()
        self.play(Write(pop_text))
        self.wait()
        stuff = VGroup(berti,christo,demi, end_node_text)
        self.play(anna_figure.animate.lower_arm("right"))
        self.play(
            anna.animate.shift(2*UP),
            stuff.animate.shift(LEFT)
        )
        self.wait()
        