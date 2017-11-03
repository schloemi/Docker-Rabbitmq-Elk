FROM logstash

RUN logstash-plugin install logstash-input-rabbitmq

COPY logstash.conf /config-dir/

CMD ["-f", "/config-dir/logstash.conf"]