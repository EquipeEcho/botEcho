c = 0
for k in range (1067, 3628):
    if k % 2 == 0 and k % 7 == 0:
        c += 1
print (c)