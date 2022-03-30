from manim import *
from Vgroups import Arr, StickFigure

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

#Neat way to highlight, none of the styles seem to suit me though
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

class ToRender(Scene):
    def construct(self):
        MyListArrayBasics.construct(self)


class MyListArrayBasics(Scene):
    def construct(self):
        #Declaring necessary objects for the scene
        #Texts
        new_list_text = Text("MyListArray myList = new MyListArray(3);",
        t2c={"MyListArray":GREEN_E, "myList":BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_annabell_text = Text("Human annabell = new Human(\"Annabell\", 29);",
        t2c={"Human":GREEN_E, "annabell": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_berti_text = Text("Human berti = new Human(\"Berti\", 56);",
        t2c={"Human":GREEN_E, "berti": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        new_christo_text = Text("Human christo = new Human(\"Christo\", 21);",
        t2c={"Human":GREEN_E, "christo": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL).shift(0.5*DOWN)
        new_demi_text = Text("Human demi = new Human(\"Demi\", 35);",
        t2c={"Human":GREEN_E, "demi": BLUE_B, "new": PURPLE_E}).scale(0.5).to_corner(UL)
        push_text_annabell = Text("myList.push(annabell);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "annabell": BLUE_B}).scale(0.5).to_corner(UL)
        push_text_berti = Text("myList.push(berti);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "berti": BLUE_B}).scale(0.5).to_corner(UL)
        push_text_christo = Text("myList.push(christo);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "christo": BLUE_B}).scale(0.5).to_corner(UL).shift(0.5*DOWN)
        push_text_demi = Text("myList.push(demi);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "demi": BLUE_B}).scale(0.5).to_corner(UL)
        annabell_name = Text("Annabell").scale(0.5)
        berti_name = Text("Berti").scale(0.5)
        christo_name = Text("Christo").scale(0.5)
        demi_name = Text("Demi").scale(0.5)
        count0 = Text("count = 0").scale(0.5).to_corner(UR)
        count1 = Text("count = 1").scale(0.5).to_corner(UR)
        count2 = Text("count = 2").scale(0.5).to_corner(UR)
        count3 = Text("count = 3").scale(0.5).to_corner(UR)
        count4 = Text("count = 4").scale(0.5).to_corner(UR)
        #MObjects
        arr = Arr(3).scale(0.75).shift(LEFT*6)
        arr.scaled = 0.75
        annabell_figure = StickFigure("29", True).scale(0.5).shift(LEFT*6+UP*1)
        annabell_name.next_to(annabell_figure, direction=DOWN)
        annabell = VGroup(annabell_figure, annabell_name)

        berti_figure = StickFigure("56", True).scale(0.5).shift(LEFT*6+UP*1)
        berti_name.next_to(berti_figure, direction = DOWN)
        berti = VGroup(berti_figure, berti_name)
        
        christo_figure = StickFigure("21", True).scale(0.5).shift(LEFT*5+ UP*1)
        christo_name.next_to(christo_figure, direction=DOWN)
        christo = VGroup(christo_figure, christo_name)

        demi_figure = StickFigure("35", True).scale(0.5).shift(LEFT*4+UP*1)
        demi_name.next_to(demi_figure, direction=DOWN)
        demi = VGroup(demi_figure, demi_name)

        #Starting the Scene
        self.play(Write(new_list_text))
        self.wait()
        self.play(FadeIn(arr, count0))
        self.wait()
        self.play(ApplyMethod(arr.shift, DOWN*2))
        self.wait()
        self.play(FadeOut(new_list_text))
        self.play(Write(new_annabell_text))
        self.wait()
        self.play(FadeIn(annabell))
        self.wait()
        self.play(FadeOut(new_annabell_text))
        self.play(Write(push_text_annabell))
        self.wait()
        self.play(ApplyMethod(annabell.scale, 0.5))
        self.play(ApplyMethod(annabell.move_to, arr.arr[0]), ReplacementTransform(count0, count1))
        self.wait()
        self.play(FadeOut(push_text_annabell))
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
        ReplacementTransform(count1, count3))
        self.wait()
        self.play(FadeOut(push_text_berti, push_text_christo))
        self.wait()
        self.play(Write(new_demi_text), FadeIn(demi))
        self.wait()
        arr = arr.add_boxes(3)
        #self.play(ApplyMethod(arr.add_boxes, 1))
        #self.wait()
        #self.play(ApplyMethod(arr.add_boxes, 2))
        self.wait()
        self.play(ApplyMethod(demi.scale, 0.5))
        self.wait()
        self.play(ApplyMethod(berti.move_to, arr.arr[3]))
        self.wait()
        