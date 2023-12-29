# Paint Brush Applet

## Abstract
Paint Brush is an Applet-based drawing application that allows users to create drawings using basic shapes, various colors. The application supports features such as color selection, shape drawing, freehand drawing, erasing, clearing all drawings, and optional features like filling shapes, undoing actions.

## Features

### 1. Color Buttons
- **Red:** Selects red color for drawing.
- **Green:** Selects green color for drawing.
- **Blue:** Selects blue color for drawing.

### 2. Shapes Buttons
- **Rectangle:** Draws a rectangle by dragging from a start point to an end point.
- **Oval:** Draws an oval by dragging from a start point to an end point.
- **Line:** Draws a line by dragging from a start point to an end point.

### 3. Free Hand Button
- Allows users to doodle freely while dragging.

### 4. Eraser Button
- Enables users to erase parts of the drawings.

### 5. Clear All Button
- Clears all drawings from the drawing area.

### 6. Filled Checkbox
- If checked, fills the Rectangle or Oval shapes with the pre-selected color.
- If not checked, draws shapes as outlines only.
### 7. Undo Button
- Allows users to undo the previous action(s).
### to run :
  1. **Download Files:**
    - Download the following files from the repository:
        - `painter.java`
        - `shapes.java`
        - `painter.html`

2. **Compile Java Files:**
    - Compile `painter.java` and `shapes.java` using the following command:
        ```bash
        javac paint.java shapes.java
        ```

3. **Run the Applet:**
    - Run the Applet using the `appletviewer` command and provide the name of the `painter.html` file:
        ```bash
        appletviewer painter.html
        ```

4. **Interact with the Applet:**
    - Once the Applet is running, interact with it using the provided buttons and checkboxes.

## Note
- This project assumes the availability of a Java environment that supports Applet-based applications.
- Enjoy drawing with Paint Brush!
