N = int(input())
isSK = True
while True:
    if N == 0:
        break
    
    if N >= 3:
        N -= 3
    else:
        N -= 1
    if isSK:
        isSK = False
    else:
        isSK = True

if isSK:
    print("CY")
else:
    print("SK")