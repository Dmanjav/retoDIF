import random

def generate_random_data():
    global id

    date = '2023-{}-{} {}:{}:{}'.format(random.randint(7, 10), random.randint(1, 28), random.randint(0, 23), random.randint(0, 59), random.randint(0, 59))
    status = random.randint(0, 1)
    code = ['AAAA030125HDFLVLA2', 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 'SACC030606HMCNLRA2', 'SILP030314HDFPPBA3']
    data = (id, date, status, random.choice(code), random.choice(code), random.randint(1, 37), random.randint(1, 9))
    id += 1
    return data

veces = 107
id = 8

# for i in range(veces):
#     print(generate_random_data())
    
def generate_califs():
    global new
    
    servicio = random.randint(1, 5)
    higiene = random.randint(1, 5)
    calidad = random.randint(1, 5)
    data = (new, servicio, higiene, calidad)
    new += 1
    
    return data

new = 1

for i in range(veces):
    print(generate_califs())