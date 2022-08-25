from manim import *
from Vgroups import Arr, ConsCell, ArrConsCells, StickFigure, Bubble, Card
from arrPushPop import MyListArrayPushPop
from arrSearch import MyListArraySearch
from arrAppendSorted import MyListArrayAppendSorted
from linkPushPop import MyListLinkedPushPop
from objClassVisualization import ObjClassVisualization
import json

class ToRender(Scene):
    def construct(self):
        attr = [
            Text("- name: String"),
            Text("- age: int")
        ]
        methods = [
            Text("+ Human()"),
            Text("+ push()"),
            Text("+ pop()")
        ]
        c = Card(_width=5, height = 3, text= Text("Human"), attributes=attr, methods=methods, round_corners=False).scale(0.5)
        self.add(c)
        #with open("code.json", "r") as f:
        #    content = json.load(f)
        #c = Code(code=content["objClassVisualization"]["code"][0], tab_width=4, background="rectangle",
        #                    language="Java",font="Courier New", style ="emacs",insert_line_no=False)
        #self.add(c)
        #ObjClassVisualization.construct(self)
        #test = StickFigure("15", False).scale(0.5)
        #test.scaled = 0.5
        #self.test_arm_movements(test)
        #self.wait()
        #grid = NumberPlane()
        #bubble = Bubble().scale(3).shift(RIGHT)
        #dot = Dot().move_to(bubble.get_middle())
        #self.add(bubble, dot)
        #Example.construct(self)

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

class Example(Scene):
    def construct(self):
        code =[
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public void Rechteck(){
                linksObenX = 2;
                linksObenY = 2;
            }
         }
        ''', #1
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public int linksObenXGeben(){
                return linksObenX;
            }
                   
        }    
        '''
        ]

        rendered_code = []
        styling = "emacs"
        for c in code:
            rendered_code.append(Code(code=c, tab_width=4, background="rectangle",
                            language="Java",font="Courier New", style =styling, insert_line_no=False))
        rendered_code[0].shift(2*UP)
        rendered_code[1].shift(2*DOWN)
        #code_file = Code(code="test.java", tab_width=4, background="rectangle",
        #                    language="Java",font="Courier New", style =styling, insert_line_no=False)
        self.add(rendered_code[0], rendered_code[1])
        #self.play(FadeIn(rendered_code[0], rendered_code[1]))
        #self.wait()
        #self.play(FadeOut(rendered_code[0], rendered_code[1]), FadeIn(code_file))
        #self.wait()