from turtle import position
from manim import *
from Vgroups import Arr, ConsCell, ArrConsCells, StickFigure

class Test(Scene):
    def construct(self):
        cons_arr = ArrConsCells(1).scale(0.5)
        cons_arr.scaled = 0.5
        self.play(FadeIn(cons_arr))
        self.wait()
        cons_arr.update_cells(3)
        self.play(ApplyMethod(cons_arr.add_cells, cons_arr.cells))
        self.wait()
 
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