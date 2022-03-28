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

class MyListArrayBasics(Scene):
    def construct(self):
        #Declaring necessary objects for the scene
        #Texts
        new_list_text = Text("MyListArray myList = new MyListArray(3);",
        t2c={"MyListArray":GREEN_E, "myList":BLUE_B, "new": PURPLE_E}).scale(0.5).shift(UP)
        new_human_text = Text("Human annabell = new Human(\"Annabell\", 29);",
        t2c={"Human":GREEN_E, "annabell": BLUE_B, "new": PURPLE_E}).scale(0.5).shift(UP)
        push_text_annabell = Text("myList.push(annabell);", 
        t2c={"myList":BLUE_B, "push": YELLOW_B, "annabell": BLUE_B}).scale(0.5).shift(UP)
        annabell_name = Text("Annabell").scale(0.5)
        count0 = Text("count = 0").scale(0.5).to_corner(UR)
        count1 = Text("count = 1").scale(0.5).to_corner(UR)
        #MObjects
        arr = Arr(3).scale(0.75).shift(LEFT*6)
        annabell_figure = StickFigure("29", True).scale(0.5).shift(LEFT*6+UP*1)
        annabell_name.next_to(annabell_figure, direction=DOWN)
        annabell = VGroup(annabell_figure, annabell_name)

        #Starting the Scene
        self.play(Write(new_list_text))
        self.wait(2)
        self.play(ApplyMethod(new_list_text.to_corner, UL))
        self.wait()
        self.play(FadeIn(arr, count0))
        self.wait()
        self.play(ApplyMethod(arr.shift, DOWN*2))
        self.wait()
        self.play(Write(new_human_text))
        self.wait()
        self.play(FadeOut(new_list_text), ApplyMethod(new_human_text.to_corner, UL))
        self.wait()
        self.play(FadeIn(annabell))
        self.wait()
        self.play(Write(push_text_annabell))
        self.wait()
        self.play(FadeOut(new_human_text), ApplyMethod(push_text_annabell.to_corner, UL))
        self.wait()
        self.play(ApplyMethod(annabell.scale, 0.5))
        self.play(ApplyMethod(annabell.move_to, arr.arr[0]), ReplacementTransform(count0, count1))
        self.wait()

