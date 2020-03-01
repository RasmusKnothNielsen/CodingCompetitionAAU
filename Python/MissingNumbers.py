def convert_to_int_array(string):
    string_array = string.split(" ")
    int_array = []
    for str in string_array:
        int_array.append(int(str))
    return int_array


if __name__ == "__main__":

    # Getting the inputs from user
    #size_first_array = int(input("Size of first input?"))
    first_array_string = input("Integers in first array, separated by space:")
    #size_second_array = int(input("Size of second input?"))
    second_array_string = input("Integers in second array, separated by space:")

    # Convert string input into int array
    first_array = convert_to_int_array(first_array_string)
    second_array = convert_to_int_array(second_array_string)

    # Figure out which array is the longest, and use that as a benchmark
    long_array = []
    short_array = []
    if first_array.count() > second_array.count():
        long_array = first_array
        short_array = second_array
    else:
        long_array = second_array
        short_array = first_array

    missing_numbers = []
    #for number in short_array:


    print(first_array)