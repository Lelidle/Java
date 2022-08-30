from distutils.fancy_getopt import wrap_text
import queue
from manim import *
from Vgroups import StickFigure, Card, Bubble

class CompPushPop(Scene):
    def construct(self):
        #Defining and placing necessary objects
        #starting screen
        headline = Text("Queue with compositum pattern", t2c={"Queue": RED_B, "compositum pattern" : GREEN_B}).scale(0.5).to_corner(UL)
        queue_card = Card(_width = 3, text = Text("Queue").scale(0.75)).scale(0.5).to_edge(LEFT)
        root_arrow = Arrow(start = ORIGIN, end=[1.5,0,0]).next_to(queue_card, RIGHT)
        root = Text("root").set_color(BLUE_B).scale(0.5).next_to(root_arrow, UP, buff=0.05)
        end_node = Card(_width=3, text = Text("EndNode").scale(0.75)).scale(0.5).next_to(root_arrow, RIGHT)
        start = VGroup(end_node, queue_card, root_arrow, root)

        #Stick_figures
        scaled = 0.3

        anna_name = Text("Anna").scale(scaled)
        berti_name = Text("Berti").scale(scaled)
        christo_name = Text("Christo").scale(scaled)
        demi_name = Text("Demi").scale(scaled)

        anna_figure = StickFigure("29", True).scale(scaled)
        anna_figure.scaled = scaled
        anna_name.next_to(anna_figure, direction=DOWN)
        anna = VGroup(anna_figure, anna_name)

        berti_figure = StickFigure("56", True).scale(scaled)
        berti_figure.scaled = scaled
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name)

        christo_figure = StickFigure("21", True).scale(scaled)
        christo_figure.scaled = scaled
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name)

        demi_figure = StickFigure("35", True).scale(scaled)
        demi_figure.scaled = scaled 
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name)

        #bubbles
        bubble_anna = Bubble(Text("push(anna)", t2c={"push": YELLOW_B, "anna": BLUE_B}).scale(0.5)).next_to(queue_card, UP, buff=0.1).scale(0.7).shift(DOWN*0.25+RIGHT*0.75)
        anna.move_to(bubble_anna.get_critical_point(UL))

        bubble_berti = Bubble(Text("push(berti)", t2c={"push": YELLOW_B, "berti": BLUE_B}).scale(0.5)).next_to(queue_card, UP, buff=0.1).scale(0.7).shift(DOWN*0.25+RIGHT*0.75)
        berti.move_to(bubble_berti.get_critical_point(UL))

        bubble_christo = Bubble(Text("push(christo)", t2c={"push": YELLOW_B, "christo": BLUE_B}).scale(0.5)).next_to(queue_card, UP, buff=0.1).scale(0.7).shift(DOWN*0.25+RIGHT*0.75)
        christo.move_to(bubble_christo.get_critical_point(UL))

        bubble_pop = Bubble(Text("pop()", t2c={"pop": YELLOW_B}).scale(0.5)).next_to(queue_card, UP, buff=0.1).scale(0.7).shift(DOWN*0.25+RIGHT*0.75)

        bubble_next_question = Bubble(Text("next?")).scale(0.5)
        bubble_next_question2 = bubble_next_question.copy()


        #nodes
        anna_node = Card(_width=3, text=Text("DataNode1").scale(0.75), attributes=[Text("data").set_color(BLUE_B)]).scale(0.5)
        berti_node = Card(_width=3, text=Text("DataNode2").scale(0.75), attributes=[Text("data").set_color(BLUE_B)]).scale(0.5)        
        christo_node = Card(_width=3, text=Text("DataNode3").scale(0.75), attributes=[Text("data").set_color(BLUE_B)]).scale(0.5)

        #arrows
        anna_card_arrow = Arrow(start=ORIGIN, end=[0,-1,0])
        anna_arrow_next = Arrow(start = ORIGIN, end = [1.5,0,0])
        anna_next = Text("next").set_color(BLUE_B).scale(0.5)
        anna_next_whole = VGroup(anna_next, anna_arrow_next)

        berti_card_arrow = Arrow(start=ORIGIN, end=[0,-1,0])
        berti_arrow_next = Arrow(start = ORIGIN, end = [1.5,0,0])
        berti_next = Text("next").set_color(BLUE_B).scale(0.5)
        berti_next_whole = VGroup(berti_next, berti_arrow_next)

        christo_card_arrow = Arrow(start=ORIGIN, end=[0,-1,0])
        christo_arrow_next = Arrow(start = ORIGIN, end = [1.5,0,0])
        christo_next = Text("next").set_color(BLUE_B).scale(0.5)
        christo_next_whole = VGroup(christo_next, christo_arrow_next)

        return_next_arrow_berti = CurvedArrow(start_point=ORIGIN, end_point=[-2,0,0], radius = -1.25)
        return_next_text_berti = Text("DataNode2").scale(0.4).next_to(return_next_arrow_berti, DOWN, buff=0.1)
        return_berti = VGroup(return_next_arrow_berti, return_next_text_berti)

        return_next_arrow_christo = CurvedArrow(start_point=ORIGIN, end_point=[-2,0,0], radius = -1.25)
        return_next_text_christo = Text("DataNode3").scale(0.4).next_to(return_next_arrow_christo, DOWN, buff=0.1)
        return_christo = VGroup(return_next_arrow_christo, return_next_text_christo)

        reroot_arrow = CurvedArrow(start_point=ORIGIN, end_point=[4,0,0], radius=-2.5)


        #random texts
        anna_node_creation = Text("new DataNode(EndNode, anna)", t2c={"new": PURPLE_E, "DataNode": GREEN_E, "EndNode": BLUE_B, "anna": BLUE_B}).scale(0.5)
        berti_node_creation = Text("new DataNode(EndNode, berti)", t2c={"new": PURPLE_E, "DataNode": GREEN_E, "EndNode": BLUE_B, "berti": BLUE_B}).scale(0.5)



        #The actual scene
        writing_rt = 0.8
        self.play(Write(headline, run_time=writing_rt))
        self.wait()
        self.play(FadeIn(start))
        self.wait()
        self.play(FadeIn(bubble_anna))
        self.wait()
        self.play(ReplacementTransform(bubble_anna, anna))
        self.wait()
        self.play(anna.animate.next_to(end_node, UP))
        self.wait()
        anna_node.next_to(end_node, RIGHT).shift(UP+RIGHT*1.5)
        anna_card_arrow.next_to(anna_node, DOWN, buff=0.1)
        anna_card = VGroup(anna_node, anna_card_arrow)
        anna_node_creation.next_to(anna_card, UP, buff=0.1)
        self.play(FadeIn(anna_card, anna_node_creation))
        self.wait()
        self.play(Unwrite(anna_node_creation, run_time = writing_rt))
        self.wait()
        self.play(anna.animate.next_to(anna_card_arrow, DOWN, buff=0.1))
        self.wait()
        anna_card.add(anna)
        anna_arrow_next.next_to(end_node, RIGHT)
        anna_next.next_to(anna_arrow_next, UP, buff=0.1)
        self.play(
            anna_card.animate.move_to(end_node.get_center()+[0,-1.18,0]),
            end_node.animate.shift(3*RIGHT),
            FadeIn(anna_next_whole)
        )
        #anna in position
        self.wait()
        self.play(FadeIn(bubble_berti))
        self.wait()
        self.play(ReplacementTransform(bubble_berti, berti))
        self.wait()
        self.play(berti.animate.next_to(anna_card, UP, buff=0.1))
        self.wait()
        bubble_next_question.next_to(anna_card, UR, buff=0.1)
        self.play(
            FadeIn(bubble_next_question),
            berti.animate.next_to(end_node, UP, buff=0.1),
            FadeOut(anna_next)
        )
        self.wait()
        berti_node.next_to(end_node, RIGHT).shift(UP+RIGHT*1.5)
        berti_card_arrow.next_to(berti_node, DOWN, buff=0.1)
        berti_card = VGroup(berti_node, berti_card_arrow)
        berti_node_creation.next_to(berti_card, UP, buff=0.1)
        self.play(FadeIn(berti_card, berti_node_creation))
        self.wait()
        self.play(Unwrite(berti_node_creation, run_time = writing_rt))
        self.wait()
        self.play(berti.animate.next_to(berti_card_arrow, DOWN, buff=0.1))
        self.wait()
        berti_card.add(berti)
        berti_arrow_next.next_to(end_node, RIGHT)
        berti_next.next_to(berti_arrow_next, UP, buff=0.1)
        self.play(
            berti_card.animate.move_to(end_node.get_center()+[0,-1.18,0]),
            end_node.animate.shift(3*RIGHT),
            FadeIn(berti_next_whole),
        )
        self.wait()
        return_berti.next_to(anna_arrow_next, DOWN, buff=0.5)
        self.wait()
        self.play(FadeIn(return_berti))
        self.wait(3)
        self.play(
            FadeOut(bubble_next_question),
            Write(anna_next),
            FadeOut(return_berti)
        )
        self.wait()
        #berti finished

        self.wait()
        self.play(FadeIn(bubble_christo))
        self.wait()
        self.play(ReplacementTransform(bubble_christo, christo))
        self.wait()
        self.play(christo.animate.next_to(anna_card, UP, buff=0.1))
        self.wait()
        self.play(
            FadeIn(bubble_next_question),
            christo.animate.next_to(berti_card, UP, buff=0.1),
            FadeOut(anna_next)
        )
        self.wait()
        bubble_next_question2.next_to(berti_card, UR, buff=0.1)
        self.play(
            FadeIn(bubble_next_question2),
            christo.animate.next_to(end_node, UP, buff=0.1),
            FadeOut(berti_next)
        )
        christo_node.next_to(end_node, RIGHT).shift(UP+RIGHT)
        christo_card_arrow.next_to(christo_node, DOWN, buff=0.1)
        christo_card = VGroup(christo_node, christo_card_arrow)
        self.play(FadeIn(christo_card))
        self.wait()
        self.play(christo.animate.next_to(christo_card_arrow, DOWN, buff=0.1))
        self.wait()
        christo_card.add(christo)
        christo_arrow_next.next_to(end_node, RIGHT)
        christo_next.next_to(christo_arrow_next, UP, buff=0.1)
        self.play(
            christo_card.animate.move_to(end_node.get_center()+[0,-1.18,0]),
            end_node.animate.shift(3*RIGHT),
            FadeIn(christo_next_whole),
        )
        self.wait()
        return_christo.next_to(berti_arrow_next, DOWN, buff=0.5)
        self.wait()
        self.play(FadeIn(return_christo))
        self.wait(3)
        self.play(
            FadeOut(bubble_next_question2),
            Write(berti_next),
            FadeOut(return_christo)
        )
        self.wait()
        self.play(FadeIn(return_berti))
        self.wait(3)
        self.play(
            FadeOut(bubble_next_question),
            Write(anna_next),
            FadeOut(return_berti)
        )
        self.wait()

        #christo done, pop time!
        self.play(FadeIn(bubble_pop))
        self.wait()
        reroot_arrow.next_to(queue_card, UR, buff=0.1)
        self.play(
            FadeOut(root_arrow),
            FadeOut(bubble_pop),
            root.animate.set_color(GREEN),
            root.animate.next_to(reroot_arrow, UP, buff=0.1),
            FadeIn(reroot_arrow)
        )
        self.wait()
        self.play(
            FadeOut(anna_next_whole)
        )
        self.wait()
        self.play(
            anna.animate.shift(LEFT*6),
            FadeOut(anna_card_arrow),
            FadeOut(anna_node)
        )
        self.wait(2)
        to_shift = VGroup(berti_card, christo_card, berti_next_whole, christo_next_whole, end_node)
        self.play(
            ReplacementTransform(reroot_arrow, root_arrow),
            root.animate.next_to(root_arrow, UP, buff=0.1),
            to_shift.animate.shift(LEFT*3)
        )
        self.wait()