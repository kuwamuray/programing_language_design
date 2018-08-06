import math
import sys
import itertools

def is_prime(x):
    N = int(math.sqrt(x) + 2)
    if x > 1 :
        divisor = 2
        for i in range(divisor,N):
            if x % i == 0 :
                return False
    else :
        return False
    return True

print("")
sys.stdout.write("all number : ")
num_of_hand=int(input())
sys.stdout.write("use number : ")
search_range_of_hand=int(input())
sys.stdout.write("field number : ")
field_number=int(input())
print("")

cards = []
for num in range(num_of_hand):
    sys.stdout.write("card"+str(num+1)+" : ")
    input_value = input()
    cards.append(input_value)

cards_combination_lists = list(itertools.permutations(cards,search_range_of_hand))

cards_string_list = []
for cards_list in cards_combination_lists:
    cards_string = ''.join(cards_list)
    cards_string_list.append(cards_string)

cards_int_list = list(map(int, cards_string_list))

cards_int_list.sort(reverse=False)

i = 0
while cards_int_list[0] < field_number :
    del cards_int_list[0]
while i + 1 < len(cards_int_list) :
    if cards_int_list[i] == cards_int_list[i+1] :
        del cards_int_list[i+1]
    else :
        i += 1

print(cards_int_list)

count = 0
mid_prime_array = [0 for i in range(9)]

for candidate in cards_int_list:
    if count == 9 :
        break
    if is_prime(candidate) :
        print(" " + str(candidate) + "is a prime number !")
        mid_prime_array[count] = candidate
        count += 1
    else :
        print(" " + str(candidate) + " is not a prime number.")

print("")
for i in range(9) :
    print("mid" + str(i+1) + " prime : " + str(mid_prime_array[i]))
print("")
