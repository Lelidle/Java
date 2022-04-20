from manim import *
from Vgroups import Arr, ConsCell, ArrConsCells, StickFigure
from arrPushPop import MyListArrayPushPop
from arrSearch import MyListArraySearch
from arrAppendSorted import MyListArrayAppendSorted
from linkPushPop import MyListLinkedPushPop

class ToRender(Scene):
    def construct(self):
        MyListLinkedPushPop.construct(self)
        #test = StickFigure("15", False).scale(0.5)
        #test.scaled = 0.5
        #self.test_arm_movements(test)
        #self.wait()

    def test_arm_movements(self, figure):
        self.play(FadeIn(figure))
        self.wait()
        self.play(ApplyMethod(figure.raise_arm, "left"))
        self.wait()
        self.play(ApplyMethod(figure.lower_arm, "left"))
        self.wait()
        self.play(ApplyMethod(figure.raise_arm, "right"))
        self.wait()
        self.play(ApplyMethod(figure.lower_arm, "right"))
        self.wait()
        self.play(ApplyMethod(figure.raise_arm, "both"))
        self.wait()
        self.play(ApplyMethod(figure.lower_arm, "both"))
        self.wait()
    
    def array_tests(self):
        arr = Arr(2, False)
        arr2 = Arr(2, True)
        self.play(FadeIn(arr))
        self.wait(2)
        arr = arr.update_boxes(2)
        self.play(ApplyMethod(arr.add_boxes, arr.arr))
        self.wait()
        self.play(ApplyMethod(arr.toggle_arrows))
        arr.toggle_arrows_prop()
        self.wait()
        self.play(ApplyMethod(arr.toggle_arrows))
        arr.toggle_arrows_prop()
        self.wait()
        self.play(FadeOut(arr))
        self.wait()
        self.play(FadeIn(arr2))
        self.wait()
        arr2 = arr2.update_boxes(2)
        self.play(ApplyMethod(arr2.add_boxes, arr2.arr))
        self.wait()