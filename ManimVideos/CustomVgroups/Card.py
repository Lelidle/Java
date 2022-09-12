from manim import *


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
