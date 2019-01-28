
Ici, je transforme une liste du genre en entrée :

    [
        {
            "countryCode": "US",                <== "US"
            "stateName": "Alabama",
            "stateCode": "US-AL"
        },
        {
            "countryCode": "US",                <== "US"
            "stateCode" : "US-NY",
            "stateName" : "New York"
        },
        {
            "countryCode": "BR",                <== "BR"
            "stateCode" : "BR-BA",
            "stateName" : "Bahia"
        },
        {
            "countryCode": "BR",                <== "BR"
            "stateCode" : "BR-MG",
            "stateName" : "Minas Gerais"
        },
        {
            "countryCode": "BR",                <== "BR"
            "stateCode" : "BR-MT",
            "stateName" : "Mato Grosso"
        }
        ...
    ]
    

... en une liste en sortie :

[
    { "us": [
           {
                 "stateCode" : "US-AL",
                 "stateName" : "Alabama"
           },
           {
                 "stateCode" : "US-NY",
                 "stateName" : "New York"
           }
        ]
    },
    
    { "br": [
           {
                 "stateCode" : "BR-BA",
                 "stateName" : "Bahia"
           },
           {
                 "stateCode" : "BR-MG",
                 "stateName" : "Minas Gerais"
           }
           ...
        ]
    },
    
    ...
]

