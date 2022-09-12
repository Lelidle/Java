from manim import *


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