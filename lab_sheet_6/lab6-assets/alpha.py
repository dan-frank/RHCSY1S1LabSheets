
# The matrix below defines a letter H
h = [[1, 0, 0, 1],
     [1, 0, 0, 1],
     [1, 1, 1, 1],
     [1, 0, 0, 1],
     [1, 0, 0, 1]]

# TODO: define matrices for the letters E, L, and O

def concat_matrices(m1, m2):
    """Creates a new matrix where each row is the concatenation of the
    corresponding rows in m1 and m2.
    :param m1: a list of lists
    :param m2: a list of lists with the same number of rows as m1
    :returns: the concatenation of m1 and m2"""
    # TODO: complete the implementation

def print_matrix(m):
    """Prints the matrix to the screen row by row. 1 is represented with
    X all other entries are shown as spaces.
    :param m: a list of lists of 0 and 1"""
    # TODO: complete the implementation

# TODO: print out hello:
# 1) first as a column, using only print_matrix,
# 2) then as a row, using concat_matrices and then print_matrix
