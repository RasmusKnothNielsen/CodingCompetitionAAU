if __name__ == "__main__":

    user_input = input("Input SOS message: ")
    if len(user_input) % 3 == 0:
        first_index = 0
        second_index = 3
        count = 0
        while second_index <= len(user_input):
            word = user_input[first_index:second_index]
            if word != "SOS":
                count += 1
            first_index += 3
            second_index += 3

        print(count)
    else:
        print("Input must be divisible by 3!")