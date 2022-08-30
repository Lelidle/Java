from xml.etree.ElementInclude import include
from manim import *
from enum import Enum

class Card(VGroup):
    '''
    The constructor set the height accordingly to the number of methods and attributes given 
    in the list. It is never smaller than 2. 
    '''
    def __init__(self, _width=4, height=2, text = Text("class"), methods=[], attributes = [], round_corners=True):
        super().__init__()
        self.scaled = 1
        height_frame = max(height, len(attributes) + len(methods) + 1)
        if(round_corners):
            frame = RoundedRectangle(corner_radius=0.5, width=_width, height = height_frame)
        else:
            frame = Rectangle(width=_width, height = height_frame)
        dividerUp= Line(start=ORIGIN, end=[_width,0,0]).move_to(frame.get_critical_point(UP)).shift(DOWN)
        self.objects = [frame, dividerUp]
        if(len(methods) > 0):
            dividerDown = Line(start=ORIGIN, end=[_width,0,0]).move_to(frame.get_critical_point(DOWN)).shift(UP*len(methods))
            self.objects.append(dividerDown)
            self.add(dividerDown)
        self.classname = text.move_to(frame.get_critical_point(UP)).shift(DOWN*0.5)
        self.methods = VGroup()
        self.attributes = VGroup()
        for i in range(len(attributes)): 
            attributes[i].move_to(frame.get_critical_point(UP)).shift(DOWN*(1.5+i))
            self.attributes.add(attributes[i])
        for i in range(len(methods)):
            methods[i].move_to(frame.get_critical_point(UP)).shift(DOWN*(1.5+len(attributes)+i))
            self.methods.add(methods[i])
        self.add(frame, dividerUp, self.classname, self.methods, self.attributes)

    def set_text_color(self, color):
        '''
        Sets the color of all texts to the same color.  
        '''
        self.classname.set_color(color)
        for a in self.attributes:
            a.set_color(color)
        for m in self.methods:
            m.set_color(color)
        return self





class Bubble(VGroup):
    '''
    Builds a thinking bubble out of 3 ellipses. Can be mirrored. Text can be added to the middle and adjusted in scale and position.
    '''
    def __init__(self, text = Text("...")):
        super().__init__()
        self.e1 = Ellipse(color=WHITE, width=3, height=1.5)
        e2 = Ellipse(color=WHITE, width=0.5, height=0.25).move_to(self.e1.get_critical_point(DL)).shift(UP*0.1+RIGHT*0.1)
        e3 = Ellipse(color=WHITE, width=0.2, height=0.1).move_to(e2.get_critical_point(DL)).shift(DOWN*0.1)
        self.ellipses = VGroup(self.e1,e2,e3)
        self.text = text
        self.text.move_to(self.e1.get_critical_point(ORIGIN))
        self.add(self.ellipses, self.text)
    
    def get_middle(self):
        '''
        returns the center coordinates of the middle ellipse.
        '''
        return self.ellipses[0].get_critical_point((0,0,0))

    def add_text_to_bubble(self, text, buff=0):
        '''
        Adds text to the center position of the bubble. Does not adjust its position in the bubble on itself.
        Parameters
        ----------
        buff: : Vector
            text will be shifted by this Vector. Example 0.1*DOWN. Only small buffs recommended
        '''
        text.move_to(self.e1.get_critical_point((0,0,0))).shift(buff)
        self.text = text
        self.add(self.text)
        return self

    def flip_bubble(self):
        '''
        mirrors the bubble at the y-axis
        '''
        self.ellipses.flip(UP)
        return self
    
    def scale_text(self, scaling):
        '''
        Scales only the text with the given scaling factor.
        Parameters
        ----------
        scaling: : double
            recommended are scalings between 0 and 1
        '''
        self.text.scale(scaling)
        return self

class Arr(VGroup):
    def __init__(self, length = 3, include_arrows = False):
        super().__init__()
        self.include_arrows = include_arrows
        self.arr = []
        self.scaled = 1
        for i in range(0, length):
            box = ArrBox(self.include_arrows, i)
            self.arr.append(box)
            self.add(box)

    def update_boxes(self, count = 1):
        for _ in range(count):
            box = ArrBox(self.include_arrows, len(self.arr)-1).scale(self.scaled)
            box.move_to(self.arr[len(self.arr)-1]).shift(self.scaled*2*RIGHT)
            self.arr.append(box)
        return self

    def add_boxes(self, boxes = 1):
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

    def color_arrows(self,color):
        for box in self.arr:
            box.color_arrow(color)
        return self

    def toggle_arrows_prop(self):
        self.include_arrows = not self.include_arrows
        for box in self.arr:
            box.include_arrows = not box.include_arrows

    def add_text_to_box_center(self,position, text, buff=0):
        text.move_to(self.arr[position].get_center()).shift(buff)
        self.add(text)
        return self
    
    def add_text_to_arrow_tip(self, position, text, buff):
        text.move_to(self.arr[position].get_tip_position()).shift(buff)
        self.add(text)
        return self

class ArrBox(VGroup):
    def __init__(self, include_arrows = False, shift=1):
        super().__init__()
        self.include_arrows = include_arrows
        square = Square().shift(2*RIGHT*shift)
        dot = Dot().move_to(square.get_center())
        self.arrow = Arrow(start=ORIGIN, end=2.5*RIGHT).rotate(-PI/2).move_to(square.get_center()).shift(DOWN)
        self.parts = [square, dot, self.arrow]
        if(include_arrows):
            self.add(square, dot, self.arrow)
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
    
    def color_arrow(self, color):
        self.arrow.set_color(color)
        return self

class ArrConsCells(VGroup):
    def __init__(self, length=3):
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