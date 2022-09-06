def show():
    print('這是bb.py')
    
def show2(x):
    for i in range(x):
        print(i)

name = 'bb.py'

def show3(x):
    for i in range(1,x+1):
        print(' '*(x-i)+'*'*(i*2-1))
