list_of_departments = [
    {
        "departmentName": "IT",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentName": "CSE",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentName": "MECH",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentName": "ECE",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentName": "EEE",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
]

import requests

for body in list_of_departments:
    requests.post(url="https://spring-boot-departments.onrender.com/departments",
                  verify=False,
                  json=body)

print("Finished Posting")


