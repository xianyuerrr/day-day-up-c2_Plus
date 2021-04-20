import random


def quick_sort(nums, left, right):
    if left >= right:
        return

    target_idx = random.randint(left, right)
    nums[target_idx], nums[left] = nums[left], nums[target_idx]
    target_idx = left
    for i in range(left+1, right+1):
        if nums[i] <= nums[left]:
            target_idx += 1
            nums[target_idx], nums[i] = nums[i], nums[target_idx]
    nums[left], nums[target_idx] = nums[target_idx], nums[left]
    
    quick_sort(nums, left, target_idx-1)
    quick_sort(nums, target_idx+1, right)
    return
