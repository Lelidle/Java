from re import S
from manim import *
from Vgroups import Arr, StickFigure

class MyListArraySearch(Scene):
    def construct(self):
        #Defining necessary MObjects and texts
        arr = Arr(6, False).scale(0.75).move_to(ORIGIN)
        arr.scaled = 0.75
        
        anna_name = Text("Anna")
        anna_figure = StickFigure("29", True)
        anna_name.next_to(anna_figure, direction=DOWN)
        anna = VGroup(anna_figure, anna_name).move_to(arr.arr[0].get_center()).scale(0.25)

        berti_name = Text("Berti")
        berti_figure = StickFigure("56", True)
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name).move_to(arr.arr[1].get_center()).scale(0.25)

        christo_name = Text("Christo")
        christo_figure = StickFigure("21", True)
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name).move_to(arr.arr[2].get_center()).scale(0.25)

        demi_name = Text("Demi")
        demi_figure = StickFigure("35", True)
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name).move_to(arr.arr[3].get_center()).scale(0.25)

        ernesto_name = Text("Ernesto")
        ernesto_figure = StickFigure("47", True)
        ernesto_name.next_to(ernesto_figure, direction=DOWN)
        ernesto = VGroup(ernesto_figure, ernesto_name).move_to(arr.arr[4].get_center()).scale(0.25)

        figaro_name = Text("Figaro")
        figaro_figure = StickFigure("31", True)
        figaro_name.next_to(figaro_figure, direction=DOWN)
        figaro = VGroup(figaro_figure, figaro_name).move_to(arr.arr[5].get_center()).scale(0.25)

        whole_array = VGroup(arr, anna, berti, christo, demi, ernesto, figaro).shift(UP)

        get_item_text = Text("Human human = myList.getItemAtPosition(4);",
         t2c={"myList":BLUE_B, "getItemAtPosition": YELLOW_B, "Human": GREEN_E, "human": BLUE_B}).scale(0.5).to_corner(UL)
        set_name_toni = Text("human.setName(\"Toni\")", 
        t2c={"human": BLUE_B, "setName": YELLOW_B}).scale(0.5).to_corner(UL)
        search_item_text = Text("int position = myList.searchItemPosition(new Human(\"Toni\", 37));", 
        t2c={"int":DARK_BROWN, "position": BLUE_B, "myList": BLUE_B, "searchItemPosition": YELLOW_B, "new": PURPLE_B,
        "Human": GREEN_E}).scale(0.5).to_corner(UL)
        search_item_text2 = Text("int position = myList.searchItemPosition(new Human(\"Demi\", 35));", 
        t2c={"int":DARK_BROWN, "position": BLUE_B, "myList": BLUE_B, "searchItemPosition": YELLOW_B, "new": PURPLE_B,
        "Human": GREEN_E}).scale(0.5).to_corner(UL)

        neq = Tex(r"$\neq$").rotate(PI/2).set_color(RED)
        eq =  Tex(r"$=$").rotate(PI/2).set_color(GREEN)

        arrow = Arrow(start=ORIGIN, end=2.5*RIGHT, color = RED
        ).rotate(PI/2).move_to(arr.arr[3].get_center()).shift(DOWN*1.95)
        human = Text("human", t2c={"human": BLUE_B}).scale(0.5).move_to(arrow.get_center() + arrow.length_over_dim(1)*0.6*DOWN)
        position = VGroup(arrow, human)

        toni_name = Text("Toni").scale(0.25).move_to(demi_name)
        not_in = Text("position = -1", t2c={"position": BLUE_B}).scale(0.5)
        in_it = Text("position = 4", t2c={"position": BLUE_B}).scale(0.5)

        self.play(FadeIn(whole_array))
        self.wait()
        self.play(Write(get_item_text))
        self.wait()
        self.play(FadeIn(position))
        self.wait()
        self.play(FadeOut(get_item_text))
        self.wait()
        self.play(Write(set_name_toni))
        self.wait()
        self.play(FadeTransform(demi_name, toni_name))
        self.wait()
        self.play(FadeOut(position, set_name_toni), FadeTransform(toni_name, demi_name))
        self.wait()

        toni_figure = StickFigure("37", True).scale(0.25)
        toni_name.next_to(toni_figure, direction=DOWN)
        toni = VGroup(toni_figure, toni_name).to_edge(LEFT)

        self.play(Write(search_item_text))
        self.wait()
        self.play(FadeIn(toni))
        self.wait()
        self.play(toni.animate.move_to(arr.arr[0].get_center() + 2.25*DOWN))
        self.wait()

        neq.next_to(toni, direction=UP)

        self.play(FadeIn(neq))
        self.wait()
        for i in range(1,6):
            self.play(FadeOut(neq), toni.animate.move_to(arr.arr[i].get_center() + 2.25*DOWN))
            self.wait()
            neq.next_to(toni, direction=UP)
            self.play(FadeIn(neq))
        self.wait()
        self.play(toni.animate.shift(RIGHT), FadeOut(neq))
        self.wait()
        not_in.move_to(toni)
        self.play(FadeTransform(toni, not_in))
        self.wait()

        demi_name2 = Text("Demi")
        demi_figure2 = StickFigure("35", True)
        demi_name2.next_to(demi_figure2, direction=DOWN)
        demi2 = VGroup(demi_figure2, demi_name2).scale(0.25).to_edge(LEFT)

        self.play(FadeOut(not_in, search_item_text))
        self.wait()
        self.play(Write(search_item_text2), FadeIn(demi2))
        self.wait()

        self.play(demi2.animate.move_to(arr.arr[0].get_center() + 2.25*DOWN))
        self.wait()

        neq.next_to(demi2, direction=UP)

        self.play(FadeIn(neq))
        self.wait()
        for i in range(1,3):
            self.play(FadeOut(neq), demi2.animate.move_to(arr.arr[i].get_center() + 2.25*DOWN))
            self.wait()
            neq.next_to(demi2, direction=UP)
            self.play(FadeIn(neq))
        self.wait()
        self.play(FadeOut(neq), demi2.animate.move_to(arr.arr[3].get_center() + 2.25*DOWN))
        self.wait()

        eq.next_to(demi2, direction=UP)
        in_it.move_to(demi2)
        self.play(FadeIn(eq))
        self.wait()
        self.play(FadeOut(eq), FadeTransform(demi2, in_it))
        self.wait()


