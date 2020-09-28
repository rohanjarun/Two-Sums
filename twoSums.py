u=[2,12,8,7]

a=[2,7,8,12]
sum =1

def gotValue(a,sum):
    n = len(a)
    n1=0
    n2=-1
    while True:
        #print(n1,n2,n)
        s = a[n1]+a[n2]
       
        if(n1 - n2 == n):
            return -1
        elif(s == sum ):
            #print(a[n1],a[n2])
            if(a[n1]==a[n2]):
                return -1
            else:
                return [u.index(a[n1]),u.index(a[n2])]
        elif(s > sum and n2 >= (-1)*n):
            n2 = n2 -1
        elif(s < sum and n1 < n-1):
            n1 = n1 + 1
        
        
        
            
    

print(gotValue(a,sum))