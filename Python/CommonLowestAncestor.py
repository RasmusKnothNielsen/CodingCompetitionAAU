class Node:

    def __init__(self, data):
        """
        Initializer for the Node object

        :param data:
            The data that we want to put inside of the node

        >>> root = Node(5)
        >>> root2 = Node("Hi")
        >>> root3 = Node(12.4)
        """
        self.data = data
        self.left = None
        self.right = None

    def insert(self, *data):
        """
        Method that inserts data into the right place in a Binary Tree.

        It is using the * syntax, which allows for unpacking of values,
        if a list of values are provided at method call.

        >>> root = Node(4)
        >>> root.insert(2)

        >>> root = Node(5)
        >>> root.insert(*[6,3,9])

        :param data: Single value or list of values
            The value og the list of values that we want to insert into the binary tree

        :return: void
            Nothing is returned, but the binary tree that the method is executed on is modified.
        """
        # Since we are unpacking values, we have to take the values one at a time
        for number in data:
            # Compare the new value with the parent node
            if self.data:
                if number < self.data:  # If number is smaller than the current node
                    if self.left is None:
                        self.left = Node(number)
                    else:
                        self.left.insert(number)
                elif number > self.data:  # If number is larger than the current node
                    if self.right is None:
                        self.right = Node(number)
                    else:
                        self.right.insert(number)
            else:
                self.data = number


def find_lowest_common_ancestor_util(root, elem1, elem2, v):
    """
    Function that returns pointers to Lowest Common Ancestors of two given values

    :param root:
        The root of the binary tree

    :param elem1:
        The first element to be searched for

    :param elem2:
        The second element to be searched for

    :param v: list
        A list containing two elements, either True or False. v[0] and v[1]
        If v[0] is True, elem1 is present in tree, and if v[1] is true, elem2 is present in tree

    :return:
        Pointers to the lowest common ancestor
    """
    # If the Binary tree is empty
    if root is None:
        return None

    # If elem1 or elem2 is in the root of the tree
    if root.data == elem1:
        v[0] = True
        return root

    if root.data == elem2:
        v[1] = True
        return root

    # Check if the elements are in the left and right subtree
    left_subtree = find_lowest_common_ancestor_util(root.left, elem1, elem2, v)
    right_subtree = find_lowest_common_ancestor_util(root.right, elem1, elem2, v)

    # If both left_subtree and right_subtree is not null, then the current node is the lowest common ancestor
    if left_subtree and right_subtree:
        return root

    # Otherwise check if left subtree or right subtree is Lowest Common Ancestor
    return left_subtree if left_subtree is not None else right_subtree


def find(root, elem):
    """
    Function to tell if a given element is found in the binary tree

    :param root:
        Root of the binary tree

    :param elem:
        The given element that is going to be searched for

    :return: Bool
        Returns true if the element is in the tree, otherwise it returns false
    """
    # Cover the base case
    if root is None:
        return False

    # If the element is present at the root, or if in left subtree or right subtree
    if root.data == elem or find(root.left, elem) or find(root.right, elem):
        return True
    # Else return false
    return False


def find_lowest_common_ancestor(root, elem1, elem2):
    """
    Function that returns Lowest Common Ancestor of two elements if, and only if, both
    elements are in the binary tree. Else it will return false

    :param root:
        Root of the binary tree.

    :param elem1:
        The first element to be searched for.

    :param elem2:
        The second element to be searched for.

    :return: Pointer/Bool
        If there is a common lowest ancestor, this will be returned. Otherwise, Else will be returned.
    """
    # Start off by marking elem1 and elem2 as not visited
    v = [False, False]

    # Find the lowest common ancestor
    lca = find_lowest_common_ancestor_util(root, elem1, elem2, v)

    # Checks if both of the provided elements are present in the tree
    if v[0] and v[1] or v[0] and find(lca, elem2) or v[1] and find(lca, elem1):
        return lca

    # If one or more of the provided elements are not in the tree, return None,
    # since one or none nodes can not have a common ancestor.
    return None


def get_user_input():
    """
    Function that helps with getting the user inputs and alters it into the desired data structures.

    :return:
        Returns the user input in the desired structure.
    """
    size = input("Please choose the size of the Binary tree: ")
    elements = input("Please enter the values for the nodes, separated by space: ")
    search = input("What you want to search for: ")

    elements = elements.split(" ")
    search = search.split(" ")

    return size, elements, search


if __name__ == "__main__":

    import doctest
    doctest.testmod()

    size, elements, search = get_user_input()
    root = Node(elements.pop(0))
    root.insert(*elements)

    lca = find_lowest_common_ancestor(root, search[0], search[1])
    if lca is not None:
        print(lca.data)
