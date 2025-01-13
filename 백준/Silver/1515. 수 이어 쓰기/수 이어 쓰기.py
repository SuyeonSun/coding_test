def find_position(nums):
    current_number = 0
    current_idx = 0

    while True:
        current_number += 1
        for char in str(current_number):
            if nums[current_idx] == char:
                current_idx += 1
                if current_idx == len(nums):
                    return current_number

nums = input()
print(find_position(nums))