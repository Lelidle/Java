from manim import *

class Stack(VGroup):
    def __init__(self, storey = 2, width = 2, height = 1, texts = [], colors = [], text_colors = []):
        super().__init__()
        self.scaled = 1
        self.boxes = []
        self.texts = []
        self.rects = []
        #construct Rectangles
        for i in range(storey):
            box = VGroup()
            rect = Rectangle(width=width, height=height)
            if(colors != []):
                rect.set_color(colors[i])

            box.add(rect)
            self.rects.append(rect)

            if(texts != []):
                text = Text(texts[i])
                if(text_colors != []):
                    text.set_color(text_colors[i])
                text.move_to(rect.get_critical_point(ORIGIN))
                self.texts.append(text)
                box.add(text)

            box.shift(UP*i*(height+0.025))
            self.boxes.append(box)
            self.add(box)

    def color_all_rectangles(self, color):
        for i in range(len(self.rects)):
            self.rects[i].set_color(color)
        return self 

    def color_rectangle(self, position, color):
        self.rects[position].set_color(color)
        return self
    
    def color_all_texts(self, color):
        for i in range(len(self.texts)):
            self.texts[i].set_color(color)
        return self 
    
    def color_text(self, position, color):
        self.texts[position].set_color(color)
        return self 

    def color_all_boxes(self, color):
        for i in range(len(self.boxes)):
            self.boxes[i].set_color(color)
        return self 
    
    def color_box(self, position, color):
        self.boxes[position].set_color(color)
        return self 

    def scale_texts(self, scaling):
        for i in range(len(self.texts)):
            self.texts[i].scale(scaling)
        return self 
    
    def scale_text(self, position, scaling):
        self.texts[position].scale(scaling)
        return self 

    def delete_text(self, position):
        self.texts[position].become(Text(""))
        return self

    def update_text(self, position, new_text, Scene):
        t = Text(new_text).move_to(self.texts[position].get_critical_point(ORIGIN))
        Scene.play(ReplacementTransform(self.texts[position], t))
        return self

'''
class Test(VGroup):
    def __init__(self):
        super().__init__()
        self.rect = Rectangle(width=2, height=1)
        self.text = Text("Test").move_to(self.rect.get_critical_point(ORIGIN))
        self.add(self.rect, self.text)

    def update_text(self, new_text):
        #???
'''

class StackTest(Scene):
    def construct(self):
        s = Stack(storey = 4, width=3, height=1, texts=["1", "2", "3", "4"])
        self.play(FadeIn(s))
        self.play(s.animate.shift(2*DOWN))
        self.wait()
        self.play(s.animate.color_all_rectangles(GREEN))
        self.wait()
        self.play(s.animate.color_rectangle(0, RED))
        self.wait()
        self.play(s.animate.color_all_texts(YELLOW))
        self.wait()
        self.play(s.animate.color_text(2, RED))
        self.wait()
        self.play(s.animate.color_all_boxes(BLUE))
        self.wait()
        self.play(s.animate.color_box(1, YELLOW))
        self.wait()
        self.play(s.animate.scale_texts(0.5))
        self.wait()
        self.play(s.animate.scale_text(3, 0.25))
        self.wait()
        self.play(s.animate.delete_text(0))
        self.wait()
        self.play(s.animate.color_all_texts(RED))
        self.wait()
        s.update_text(0, "first", self)
        self.wait()