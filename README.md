Orthogonal Grid Generator
=========================

This is a basic implementation of a Direct("Compass") Search algorithm to
improve the cell centre location of grid cells in an unstructured grid.

The applications takes a JSON file with grid info and optimizes that grid.
The format of the JSON file can be inferred from one of the sample files
provided along with the source code.

Only two types of grid are supported, namely hexahedral and 2.5 unstructed
grid.

Arguments
---------

Following arguments can be supplied to the application along with the JSON
file:

 - '--gf' - dumps the details of the grid and every iteration to a file,
 - '--gs' - dumps the details of the grid and every iteration to Stdout,
 - '--runs [number]' - define the number of iterations,
 - '--step [number]' - define the step size for the search method, and
 - '--limit [number]' - define the limit of iterations having same cost.

