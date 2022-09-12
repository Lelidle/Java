from manim import *



class Bodyparts(Enum):
    LEFT_LEG = 0
    RIGHT_LEG = 1
    LEFT_ARM = 2
    RIGHT_ARM = 3
    HEAD = 4
    BODY = 5
    AGE = 6

class StickFigure(VGroup):
    def __init__(self, age, display_age = False):
        super().__init__()
        head = Circle(radius=0.5, color=WHITE).shift(1.5*UP)
        body = Line().rotate(PI/2)
        left_leg = Line().scale(0.75).rotate(PI/3).shift(1.6*DOWN+0.38*LEFT)
        right_leg = Line().scale(0.75).rotate(-PI/3).shift(1.6*DOWN+0.38*RIGHT)
        left_arm = Line().scale(0.5).rotate(PI/6).shift(0.4*LEFT)
        right_arm = Line().scale(0.5).rotate(-PI/6).shift(0.4*RIGHT)
        age_text = Text(str(age)).shift(1.5*UP)
        self.scaled = 1
        self.display_age = display_age
        self.bodyparts = [left_leg, right_leg, left_arm, right_arm, head, body, age_text]
        self.add(head, body, left_leg, right_leg, left_arm, right_arm)
        if display_age:
            self.add(age_text)
    
    def get_arm_position(self, side):
        if(side == "right"):
            return self.bodyparts[Bodyparts.RIGHT_ARM.value].get_critical_point(RIGHT)
        elif (side == "left"):
            return self.bodyparts[Bodyparts.LEFT_ARM.value].get_critical_point(LEFT)            

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
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(-PI/6).shift(self.scaled*(0.2*UP+0.1*LEFT))
        elif side == "right":
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(PI/6).shift(self.scaled*(0.2*UP+0.1*RIGHT))
        elif side == "both":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(-PI/6).shift(self.scaled*(0.2*UP+0.1*LEFT))
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(PI/6).shift(self.scaled*(0.2*UP+0.1*RIGHT))

    def lower_arm(self, side):
        """
        Method can be used to lowers the arms of the stick figure
        implemented directions: left, right, both
        """
        if side == "left":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(PI/6).shift(self.scaled*(0.2*DOWN+0.1*RIGHT))
        elif side == "right":
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(-PI/6).shift(self.scaled*(0.2*DOWN+0.1*LEFT))
        elif side == "both":
            self.bodyparts[Bodyparts.LEFT_ARM.value].rotate(PI/6).shift(self.scaled*(0.2*DOWN+0.1*RIGHT))
            self.bodyparts[Bodyparts.RIGHT_ARM.value].rotate(-PI/6).shift(self.scaled*(0.2*DOWN+0.1*LEFT))
