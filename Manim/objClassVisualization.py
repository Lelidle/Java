from manim import *
from Vgroups import Bubble

class ObjClassVisualization(Scene):
    def construct(self):
        #Code-snippets to render
        code =['''
        public class Rechteck(){ 
            private int linksObenX;
            private int linksObenY;
            private int laenge;
            private int breite;
            private String farbe;
        }
        ''', #1
         '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;
        }
        ''', #2
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public Rechteck(){
                linksObenX = 2;
                linksObenY = 2;
                laenge = 4;
                breite = 2;
                farbe = "weiss";
            }
         }
        ''', #3
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public int linksObenXGeben() {
                return linksObenX;}          
        }    
        ''', #4
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public int laengeGeben() {
                return laenge;}          
         }
        ''', #5
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public String farbeGeben() {
                return farbe;}          
         }
        ''', #6
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public void farbeSetzen(String farbeNeu) {
                farbe = farbeNeu;}          
         }
        ''', #7
        '''
        public class Rechteck(){
            private int linksObenX, linksObenY, laenge, breite;
            private String farbe;

            public void laengeSetzen(int laengeNeu) {
                laenge = laengeNeu;}          
         }
        '''
        ]
        method_calls = [
            '''
            Rechteck rechteck = new Rechteck();
            ''',#1
            '''
            rechteck.linksObenXGeben();
            ''',#2
            '''
            rechteck.laengeGeben();
            ''', #3
            '''
            rechteck.farbeGeben();
            ''', #4
            '''
            rechteck.farbeSetzen("grün");
            ''', #5
            '''
            rechteck.laengeSetzen(3);
            '''
        ]

        #Rendering
        rendered_code = []
        rendered_method_calls = []
        i = 0
        styling = "emacs"
        for c in code:
            rendered_code.append(Code(code=c, tab_width=4, background="rectangle",
                            language="Java",font="Courier New", style =styling, insert_line_no=False))
            i +=1
        for i in range(1, len(rendered_code)):
            rendered_code[i].scale(0.6).to_corner(UL)
        for m in method_calls:
            rendered_method_calls.append(Code(code=m, tab_width=4, background="rectangle",
                            language="Java",font="Courier New", style =styling, insert_line_no=False))
        for i in range(0, len(rendered_method_calls)):
            rendered_method_calls[i].scale(0.8).to_edge(LEFT).shift(DOWN*2)

        # Other text and MObjects
        # Here we do our method calls! :D
        console = Text("Konsole").to_edge(LEFT).shift(DOWN)
        # Rectangle without the Rectangle class to be able to Indicate single lines
        rect_up = Line(start=ORIGIN, end=4*RIGHT).shift(UP)
        rect_down = Line(start=ORIGIN, end=4*RIGHT).shift(DOWN)
        rect_left=Line(start=ORIGIN, end=2*RIGHT).rotate(PI/2).shift(LEFT)
        rect_right = Line(start=ORIGIN, end=2*RIGHT).rotate(PI/2).shift(3*RIGHT)
        rect = VGroup(rect_up, rect_down, rect_left,rect_right).shift(2*RIGHT)
        #Rectangle property visualization objects
        two_text = Tex(r"$2$")
        three_text = Tex(r"$3$")
        four_text = Tex(r"$4$")
        right_brace = VGroup(Brace(rect_right,direction=RIGHT).put_at_tip(two_text), two_text)
        down_brace= VGroup(Brace(rect_down, direction=DOWN).put_at_tip(four_text), four_text)
        corner_point = Dot().move_to(rect_left.get_critical_point(UP))
        point_coords = Tex(r"$(2\vert2)$").next_to(corner_point, direction=UP, buff=0.1)
        explaining_stuff = VGroup(right_brace, down_brace, corner_point, point_coords)
        #Thinking bubble "return statements!"
        bubble = Bubble().next_to(rect_up, direction=UP).shift(0.5*RIGHT +0.5*UP).set_color(RED)
        text_linksObenX = Tex(r"$2$").move_to(bubble.get_middle()).set_color(RED)
        text_laenge = Tex(r"$4$").move_to(bubble.get_middle()).set_color(RED)
        text_farbe = Text("\"weiss\"").move_to(bubble.get_middle()).set_color(RED)

        ax = Axes(
            x_range=[0,5,1],
            y_range = [0,3,1],
            tips = True,
            axis_config={"include_numbers": True}
        )
        ax.move_to(rect_left.get_critical_point(DOWN))

        self.play(FadeIn(rendered_code[0]))
        self.wait(2)
        self.play(FadeTransform(rendered_code[0], rendered_code[1]))
        self.wait(2)
        self.play(FadeTransform(rendered_code[1], rendered_code[2]))
        self.wait(2)
        self.play(FadeIn(console, rendered_method_calls[0]))
        self.wait(2)
        self.play(FadeIn(rect))
        self.wait(2)
        self.play(FadeIn(explaining_stuff))
        self.wait(2)
        self.play(FadeOut(rendered_method_calls[0]))
        self.wait(2)
        self.play(FadeIn(rendered_method_calls[1]), FadeTransform(rendered_code[2], rendered_code[3]))
        self.wait(2)
        self.play(FadeIn(bubble, text_linksObenX))
        self.wait(2)
        self.play(FadeOut(rendered_method_calls[1], text_linksObenX))
        self.play(FadeIn(rendered_method_calls[2]), FadeTransform(rendered_code[3], rendered_code[4]))
        self.wait(2)
        self.play(FadeIn(text_laenge))
        self.wait(2)
        self.play(FadeOut(rendered_method_calls[2], text_laenge))
        self.play(FadeIn(rendered_method_calls[3]), FadeTransform(rendered_code[4], rendered_code[5]))
        self.wait(2)
        self.play(FadeIn(text_farbe))
        self.wait(2)
        self.play(FadeOut(bubble, text_farbe, rendered_method_calls[3]))
        self.wait(2)
        self.play(FadeIn(rendered_method_calls[4]), FadeTransform(rendered_code[5], rendered_code[6]))
        self.wait(2)
        self.play(rect.animate.set_color(GREEN))
        self.wait(2)
        self.play(FadeOut(rendered_method_calls[4]))
        self.wait(2)
        self.play(FadeIn(rendered_method_calls[5]), FadeTransform(rendered_code[6], rendered_code[7]))
        self.wait(2)
        factor = 0.5
        three_text.move_to(four_text).shift(factor*LEFT)
        self.play(
            rect_right.animate.shift(LEFT),
            rect_up.animate.scale(0.75).shift(factor*LEFT),
            rect_down.animate.scale(0.75).shift(factor*LEFT),
            right_brace.animate.shift(LEFT),
            down_brace.animate.scale(0.75).shift(factor*LEFT),
            FadeTransform(four_text, three_text)
        )
        self.wait(2)