import json
import re

def py_auth(public_credentials, private_credentials, principals):
    return True

def py_map(principals):
    for p in principals:
        if p.split(":")[0] == "oidcclaims":
            value = p[re.search(":", p).start()+1:]
            split_at = re.search(r'@(?=[A-Za-z0-9_-]+$)', value).start()
            jsonstring = value[:split_at]
            op = value[split_at+1:]
            data = json.loads(jsonstring)

            # specific for Christian
            if "admin" in data["jsonclaim"]["realm_access"]["roles"]:
                principals.add("uid:0")
                principals.add("gid:0")
    return True