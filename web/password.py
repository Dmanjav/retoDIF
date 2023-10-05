from werkzeug.security import generate_password_hash, check_password_hash
password = 'Amp. Adolfo Lopez Mateos'
hashed_pass = generate_password_hash(password)

print(hashed_pass)
print(check_password_hash(hashed_pass,password))
print(password)