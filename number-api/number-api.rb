require 'sinatra/base'

class PolyglotApp < Sinatra::Base
    enable :static
    set :server, 'webrick'
    disable :logging

    config = Java.type("org.eclipse.microprofile.config.ConfigProvider").getConfig()
    port = config.getOptionalValue("NUMBER_API_PORT", Java.type("java.lang.Integer")).orElse(3001)
    set :port, port

    get '/number-api/number/generate' do
      'MV-' + (rand(9999999) + 1).to_s.rjust(7, "0")
    end
end

PolyglotApp.run!
