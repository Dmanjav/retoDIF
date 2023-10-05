from werkzeug.security import generate_password_hash, check_password_hash
password = 'Pablo'
hashed_pass = generate_password_hash(password)

print(hashed_pass)
print(check_password_hash(hashed_pass,password))
print(password)