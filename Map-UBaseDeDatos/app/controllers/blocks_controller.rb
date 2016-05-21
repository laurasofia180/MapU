class BlocksController < ApplicationController
	
	#Get /blocks
	def index
     @blocks = Block.all #Nos permite traer todos los registros, el "@" es para permitir que la vista acceda 
	end	
	#Get /blocks/:id
	def show
      @block = Block.find(params[:id]) #Va a encontrar un registro por su id
	end	

	#Get /blocks/new
	def new 
		@block = Block.new 
	end

	def edit
	@block = Block.find(params[:id])
	end

	#POST /blocks
	def create
		@block = Block.new(block_params)#(IdBloque: params[:block][:IdBloque],NoBloque: params[:block][:NoBloque])
		
		if @block.save
			redirect_to @block
		else
			render :new 
		end 
	end

	def destroy
		@block = Block.find(params[:id])
		@block.destroy # elimina el obj de la BD
		redirect_to blocks_path
	end
	
	#PUT /blocks/:id
	def update
		@block = Block.find(params[:id])
			if @block.update(block_params)
				redirect_to @block
			else
				render :edit
		    end		
	end
	
	private
	def block_params
		params.require(:block).permit(:IdBloque,:NoBloque,:InfoBloque)
	end
end