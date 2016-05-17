class Block < ActiveRecord::Base
#la tabla => blocks --> tabla que busca en BD
#campos => block.title()=> "titulo del bloque"
#Escribir metodos
validates :IdBloque, presence: true, uniqueness: true 
validates :NoBloque, presence: true 
end
