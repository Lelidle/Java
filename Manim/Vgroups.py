from xml.etree.ElementInclude import include
from manim import *
from enum import Enum

class Arr(VGroup):
    def __init__(self, length, include_arrows):
        super().__init__()
        self.include_arrows = include_arrows
        self.arr = []
        self.scaled = 1
        for i in range(0, length):
            box = ArrBox(self.include_arrows, i)
            self.arr.append(box)
            self.add(box)

    def update_boxes(self, count):
        for _ in range(count):
            box = ArrBox(self.include_arrows, len(self.arr)-1).scale(self.scaled)
            box.move_to(self.arr[len(self.arr)-1]).shift(self.scaled*2*RIGHT)
            self.arr.append(box)
        return self

    def add_boxes(self, boxes):
        for box in boxes:
            self.add(box)       
        return self

    def update_scale(self, scale):
        self.scaled = scale
        return self

    def toggle_arrows(self):
        for box in self.arr:
            box.toggle_arrow()
        return self

    def toggle_arrows_prop(self):
        self.include_arrows = not self.include_arrows
        for box in self.arr:
            box.include_arrows = not box.include_arrows

class ArrBox(VGroup):
    def __init__(self, include_arrows, shift):
        super().__init__()
        self.include_arrows = include_arrows
        square = Square().shift(2*RIGHT*shift)
        dot = Dot().move_to(square.get_center())
        arrow = Arrow(start=ORIGIN, end=2.5*RIGHT).rotate(-PI/2).move_to(square.get_center()).shift(DOWN)
        self.parts = [square, dot, arrow]
        if(include_arrows):
            self.add(square, dot, arrow)
        else:
            self.add(square)

    def toggle_arrow(self):
        if(self.include_arrows):
            self.include_arrows = False
            self.remove(self.parts[1], self.parts[2])
        else:
            self.include_arrows = True
            self.add(self.parts[1], self.parts[2])
    
    def get_tip_position(self):
        return self.parts[2].get_center() \
                + self.parts[2].length_over_dim(1)*0.5*DOWN 

class ArrConsCells(VGroup):
    def __init__(self, length):
        super().__init__()
        self.scaled = 1
        cell = ConsCell().shift(3*LEFT* (length - 1))
        self.cells = [cell]
        self.add(cell)
        for _ in range(length-1):
            cell = ConsCell()
            cell.move_to(self.cells[len(self.cells)-1].get_tip_position("right")+3*RIGHT + 0.5*DOWN)
            self.cells.append(cell)
            self.add(cell)

    def update_cells(self, number):
        for _ in range(number):
            self.cells.append(ConsCell().scale(self.scaled).move_to(
                self.cells[len(self.cells)-1].get_tip_position("right")+(3*RIGHT + 0.5*DOWN)*self.scaled))
    
    def add_cells(self, cells):
        for cell in cells:
            self.add(cell)
        return self

class ConsParts(Enum):
    SQUARE_LEFT = 0
    SQUARE_RIGHT = 1
    DOT_LEFT = 2
    DOT_RIGHT = 3
    ARROW_LEFT = 4
    ARROW_RIGHT = 5

class ConsCell(VGroup):
    def __init__(self):
        super().__init__()
        square_left = Square().shift(LEFT)
        square_right = Square().shift(RIGHT)
        dot_left = Dot().move_to(square_left.get_center())
        dot_right = Dot().move_to(square_right.get_center())
        arrow_left = Arrow(start=ORIGIN, end=2.5*RIGHT).rotate(-PI/2).move_to(
            square_left.get_center()).shift(DOWN)
        arrow_right = Arrow(start=ORIGIN,end=2.5*RIGHT).move_to(
            square_right.get_center()).shift(RIGHT)
        self.parts = [square_left, square_right, dot_left, dot_right, arrow_left, arrow_right]
        for part in self.parts:
            self.add(part)
        

    def get_tip_position(self, direction):
        if direction in ["left", "Left", "down", "Down"]:
            return self.parts[ConsParts.ARROW_LEFT.value].get_center() \
                + self.parts[ConsParts.ARROW_LEFT.value].length_over_dim(1)*0.5*DOWN 
        elif direction in ["right", "Right"]:
            return self.parts[ConsParts.ARROW_RIGHT.value].get_center() \
                + self.parts[ConsParts.ARROW_RIGHT.value].length_over_dim(0)*0.5*RIGHT



class Bodyparts(Enum):
    LEFT_LEG = 0
    RIGHT_LEG = 1
    LEFT_ARM = 2
    RIGHT_ARM = 3
    HEAD = 4
    BODY = 5
    AGE = 6

class StickFigure(VGroup):
    def __init__(self, age, display_age):
        super().__init__()
        head = Circle(radius=0.5, color=WHITE).shift(1.5*UP)
        body = Line().rotate(PI/2)
        left_leg = Line().scale(0.75).rotate(PI/3).shift(1.6*DOWN+0.38*LEFT)
        right_leg = Line().scale(0.75).rotate(-PI/3).shift(1.6*DOWN+0.38*RIGHT)
        left_arm = Line().scale(0.5).rotate(PI/6).shift(0.4*LEFT)
        right_arm = Line().scale(0.5).rotate(-PI/6).shift(0.4*RIGHT)
        age_text = Text(age).shift(1.5*UP)

        self.display_age = display_age
        self.bodyparts = [left_leg, right_leg, left_arm, right_arm, head, body, age_text]
        self.add(head, body, left_leg, right_leg, left_arm, right_arm)
        if display_age:
            self.add(age_text)
    
    def alter_age_visibility(self):
        if self.display_age == True:
            self.display_age = False
            self.remove(self.bodyparts[Bodyparts.AGE.value])
        elif self.display_age == False:
            self.display_age = True
            self.add(self.bodyparts[Bodyparts.AGE.value])

    def raise_arm(self,side):
        """
        Method can be used to raise the arms of the stick figure
        implemented directions: left, right, both
        """
        if side == "left":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(-PI/6).shift(0.2*UP+0.1*LEFT)
        elif side == "right":
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(PI/6).shift(0.2*UP+0.1*RIGHT)
        elif side == "both":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(-PI/6).shift(0.2*UP+0.1*LEFT)
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(PI/6).shift(0.2*UP+0.1*RIGHT)

    def lower_arm(self, side):
        """
        Method can be used to lowers the arms of the stick figure
        implemented directions: left, right, both
        """
        if side == "left":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(PI/6).shift(0.2*DOWN+0.1*RIGHT)
        elif side == "right":
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(-PI/6).shift(0.2*DOWN+0.1*LEFT)
        elif side == "both":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(PI/6).shift(0.2*DOWN+0.1*RIGHT)
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(-PI/6).shift(0.2*DOWN+0.1*LEFT)

class Example(Scene):
    def construct(self):
        test = Testing()
        print(test)
        self.play(ApplyMethod(test.test_method, 7))
        print(test)
        print(test.property)

class Testing(VGroup):
    def __init__(self):
        super().__init__()
        self.property = 5
    def test_method(self,prop):
        self.property = prop
        self.add(Square())
        return self