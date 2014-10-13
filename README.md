WireframeToJavaFX
=================

Parses WireframeSketcher screen files into a functional JavaFX. Adds support for simple and intuitive scripting. 
E.g a label is only visible if a boolean variable is true, pressing a button sets the variable to true.
All variable declarations and scripting is done using visual elements inside WireframeSketcher.


Dependencies:
Xtend, JavaFX, Apache Commons IO

Run Generator.xtend followed by AppController.xtend.


Note!

This is a prototype and proof of concept.

Only the following JavaFX types are supported:

- Label
- Button
- Checkbox
- Radiobutton
- Image
- TextField
- TextArea
- Seperator (horizontal and vertical)

Widgets representing other types are simply ignored.
