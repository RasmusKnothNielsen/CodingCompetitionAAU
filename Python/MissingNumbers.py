"""
Missing Numbers.
Numeros the Artist had two lists that were permutations of one another. He was very proud. Unfortunately, while transporting them from one exhibition to another, some numbers were lost
out of the first list. Can you find the missing numbers?

Find the PDF for full description in Exercises.

@Author: Rasmus Knoth Nielsen, 2020 Advanced Python
"""

from collections import Counter


def get_user_input():
    # Getting the inputs from user
    size_of_first_array = input("Size of first sample: ")
    first_array_string = input("Integers in first array, separated by space: ")
    size_of_second_array = input("Size of second sample: ")
    second_array_string = input("Integers in second array, separated by space: ")

    # Converting strings to arrays
    arr = convert_string_to_array(first_array_string)
    brr = convert_string_to_array(second_array_string)

    return arr, brr


def convert_string_to_array(string):
    string_array = string.split(" ")
    return string_array


def compare_length(arr, brr):
    shortest, longest = [], []
    if len(arr) > len(brr):
        longest = arr
        shortest = brr
    else:
        longest = brr
        shortest = arr

    return shortest, longest


def get_difference(arr, brr):
    c1 = Counter(brr)
    c2 = Counter(arr)

    return c1 - c2


if __name__ == "__main__":
    # Get the user input
    first_array, second_array = get_user_input()
    # Find the longest and shortest array
    short_array, long_array = compare_length(first_array, second_array)
    # Get the difference
    diff = get_difference(short_array, long_array)
    # Sort the list and print it out as a single string
    diff = sorted(list(diff.elements()))
    print(' '.join(diff))
