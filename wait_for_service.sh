while [[ "$(curl -s -o /dev/null -w "%{http_code}" $1)" == "000" ]]
do
    echo "waiting for $1"
    sleep $2
done