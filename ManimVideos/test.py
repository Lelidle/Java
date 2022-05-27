import json
from manim import *

class Testing(Scene):
    def construct(self):
        with open("test.json", "r") as f:
            content = json.load(f)["code"]
        code = Code(code=content, tab_width=4, background="rectangle",
                            language="Java",font="Courier New", style ="emacs", insert_line_no=False)
        self.add(code)

if __name__ == "__main__":
    code = {
        "code": '''
        public class Code(){
            public method(){
                method;
            }
        }
        '''
    }
    with open("test.json", "r") as f:
        print(json.load(f)["code"])