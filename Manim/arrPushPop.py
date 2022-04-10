from manim import *
from Vgroups import Arr, StickFigure, ArrConsCells, ConsParts, Bodyparts

# Enables option to render multiple scenes or switch between
# combinations of scenes to render at the start of the file
class ToRender(Scene):
    def construct(self):
        MyListArrayPushPop.construct(self)
        #self.clear()
        # Scene2.construct(self)


class MyListArrayPushPop(Scene):
    def construct(self):
        #Declaring necessary objects for the scene
        #Texts
        new_list_text = Text("MyListArray myList = new MyListArray(3);",
        t2c={"MyListArray":GREEN_E, "myList":BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_anna_text = Text("Human anna = new Human(\"Anna\", 29);",
        t2c={"Human":GREEN_E, "anna": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_berti_text = Text("Human berti = new Human(\"Berti\", 56);",
        t2c={"Human":GREEN_E, "berti": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_christo_text = Text("Human christo = new Human(\"Christo\", 21);",
        t2c={"Human":GREEN_E, "christo": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL).shift(0.5*DOWN)
        new_demi_text = Text("Human demi = new Human(\"Demi\", 35);",
        t2c={"Human":GREEN_E, "demi": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        push_text_anna = Text("myList.push(anna);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "Anna": BLUE_B}).scale(0.5).to_corner(UL)
        push_text_berti = Text("myList.push(berti);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "berti": BLUE_B}).scale(0.5).to_corner(UL)
        push_text_christo = Text("myList.push(christo);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "christo": BLUE_B}).scale(0.5).to_corner(UL).shift(0.5*DOWN)
        push_text_demi = Text("myList.push(demi);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "demi": BLUE_B}).scale(0.5).to_corner(UL)
        pop_text = Text("myList.pop();", t2c={"myList": BLUE_B, "pop": YELLOW_B}).scale(0.5).to_corner(UL)

        anna_name = Text("Anna").scale(0.5)
        berti_name = Text("Berti").scale(0.5)
        christo_name = Text("Christo").scale(0.5)
        demi_name = Text("Demi").scale(0.5)

        count0 = Text("count = 0").scale(0.5).to_corner(UR)
        count1 = Text("count = 1").scale(0.5).to_corner(UR)
        count3 = Text("count = 3").scale(0.5).to_corner(UR)
        count4 = Text("count = 4").scale(0.5).to_corner(UR)

        #Texts Technically more accurate
        disclaimer = Text("A more technical accurate visualization would be the following:").scale(0.5).to_corner(UL)
        #MObjects
        arr = Arr(3, False).scale(0.75).shift(LEFT*6)
        arr.scaled = 0.75

        arrPartTwo = Arr(4, False).shift(4*LEFT)
        for box in arrPartTwo:
            box.parts[1].shift(4*LEFT)
            box.parts[2].shift(4*LEFT)

        anna_figure = StickFigure("29", True).scale(0.5).shift(LEFT*6+UP*1)
        anna_name.next_to(anna_figure, direction=DOWN)
        anna = VGroup(anna_figure, anna_name)

        berti_figure = StickFigure("56", True).scale(0.5).shift(LEFT*6+UP*1)
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name)

        christo_figure = StickFigure("21", True).scale(0.5).shift(LEFT*4+ UP*1)
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name)

        demi_figure = StickFigure("35", True).scale(0.5).shift(LEFT*6+UP*1)
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name)
        
        #Starting the Scene - Part 1
        self.play(Write(new_list_text))
        self.wait()
        self.play(FadeIn(arr, count0))
        self.wait()
        self.play(ApplyMethod(arr.shift, DOWN*2))
        self.wait()
        self.play(FadeOut(new_list_text))
        self.play(Write(new_anna_text))
        self.wait()
        self.play(FadeIn(anna))
        self.wait()
        self.play(FadeOut(new_anna_text))
        self.play(Write(push_text_anna))
        self.wait()
        self.play(ApplyMethod(anna.scale, 0.5))
        self.play(ApplyMethod(anna.move_to, arr.arr[0]), FadeTransform(count0, count1))
        self.wait()
        self.play(FadeOut(push_text_anna))
        self.play(FadeIn(new_berti_text, new_christo_text) )
        self.wait()
        self.play(FadeIn(berti, christo))
        self.wait()
        self.play(FadeOut(new_berti_text, new_christo_text))
        self.play(Write(push_text_berti), Write(push_text_christo))
        self.wait()
        self.play(ApplyMethod(berti.scale, 0.5), ApplyMethod(christo.scale, 0.5))
        self.wait()
        self.play(ApplyMethod(berti.move_to, arr.arr[1]), ApplyMethod(christo.move_to, arr.arr[2]),
        FadeTransform(count1, count3))
        self.wait()
        self.play(FadeOut(push_text_berti, push_text_christo))
        self.wait()
        self.play(Write(new_demi_text), FadeIn(demi))
        self.wait()
        self.play(FadeOut(new_demi_text))
        self.wait()
        self.play(Write(push_text_demi))
        arr = arr.update_boxes(3)
        self.play(ApplyMethod(arr.add_boxes, arr.arr))
        self.wait()
        self.play(ApplyMethod(demi.scale, 0.5))
        self.wait()
        self.play(ApplyMethod(demi.move_to, arr.arr[3]), FadeTransform(count3, count4))
        self.wait()
        whole_array = VGroup(arr, anna, berti, christo, demi)
        self.play(ApplyMethod(whole_array.move_to, ORIGIN), FadeOut(push_text_demi))
        self.wait()
        self.play(Write(pop_text))
        self.wait()
        self.play(ApplyMethod(anna.shift, LEFT*2), FadeTransform(count4,count3))
        self.wait()
        rest = VGroup(berti, christo, demi)
        self.play(ApplyMethod(rest.shift, LEFT*1.5))
        self.wait()
        self.play(FadeOut(anna, pop_text))
        self.wait()

        """
        #Part 2 - more accurate
        self.clear()
        self.wait()
        self.play(Write(disclaimer))
        self.wait()
        self.play(FadeIn(arrPartTwo))
        self.wait()
        self.play(ApplyMethod(arrPartTwo.toggle_arrows))
        arrPartTwo.toggle_arrows_prop()
        self.wait()
        self.play(ApplyMethod(arrPartTwo.scale, 0.75))
        arrPartTwo.scaled = 0.75
        self.wait()
        anna.to_edge(LEFT).shift(4*UP)
        berti.to_edge(LEFT).shift(4*UP)
        christo.to_edge(LEFT).shift(4*UP)
        demi.to_edge(LEFT).shift(4*UP)
        self.play(FadeIn(anna))
        moving_position = arrPartTwo.arr[0].get_tip_position() + DOWN * 0.75
        self.play(ApplyMethod(anna.move_to, moving_position))
        self.wait()
        """


class ConsScene(Scene):
    def construct(self):
        # Use Mobjects and Texts from Scene before if wanted again - so far only dump
        # Part 2 Video
        cons_arr = ArrConsCells()
        self.clear()
        self.wait()
        self.play(FadeIn(cons_arr), Write(disclaimer))
        self.wait()
        first_cell=cons_arr.cells[0]
        self.play(Indicate(first_cell.parts[ConsParts.ARROW_LEFT.value], scale_factor=2, run_time=3))
        self.wait()
        anna.to_edge(LEFT).shift(4*UP)
        berti.to_edge(LEFT).shift(4*UP)
        christo.to_edge(LEFT).shift(4*UP)
        demi.to_edge(LEFT).shift(4*UP)
        self.play(FadeIn(anna))
        self.wait()
        moving_position = cons_arr.cells[0].get_tip_position("left") + DOWN*0.75
        self.play(ApplyMethod(anna.move_to, moving_position))
        self.wait()
        cons_arr.update_cells(3)
        self.play(ApplyMethod(cons_arr.add_cells, cons_arr.cells, run_time = 2))
        self.wait()
        moving_position = cons_arr.cells[1].get_tip_position("left") + DOWN*0.75
        self.play(FadeIn(berti))
        self.wait()
        self.play(ApplyMethod(berti.move_to, moving_position))
        self.wait()
        moving_position = cons_arr.cells[2].get_tip_position("left") + DOWN*0.75
        self.play(FadeIn(christo))
        self.wait()
        self.play(ApplyMethod(christo.move_to, moving_position))
        self.wait()
        moving_position = cons_arr.cells[3].get_tip_position("left") + DOWN*0.75
        self.play(FadeIn(demi))
        self.wait()
        self.play(ApplyMethod(demi.move_to, moving_position))
        self.wait()        



class QueueTestScene(Scene):
    def construct(self):
        figures = []
        ages=["7", "15", "27", "35", "46"]
        arr = Arr(5).shift(3*LEFT+0.5*DOWN)
        for i in range(5):
            self.play(FadeIn(arr.arr[i]))
            figures.append(StickFigure(ages[i], True).shift(3*LEFT + 2*i*RIGHT+2.5*UP).scale(0.4))
            self.play(FadeIn(figures[i]))
            self.wait()
            self.play(ApplyMethod(figures[i].shift, 3*DOWN))
            self.wait()

#Neat way to highlight, none of the styles seem to suit me personally though
class CodeFromString(Scene):
    def construct(self):
        code = '''
        Human human = new Human();
        MyListArray myList = new MyListArray(3);
        myList.push(human);
'''
        rendered_code = Code(code=code, tab_width=4, background="rectangle",
                            language="Java", font="Monospace", style=Code.styles_list[30])
        self.play(FadeIn(rendered_code))
        self.wait(5)