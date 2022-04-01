from turtle import position
from manim import *
from Vgroups import Arr, ConsCell, ArrConsCells, StickFigure

class Test(Scene):
    def construct(self):
        figure = StickFigure("15", False)
        
        self.play(FadeIn(figure))
        self.wait()
        figure.alter_age_visibility()
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