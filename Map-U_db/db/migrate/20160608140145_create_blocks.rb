class CreateBlocks < ActiveRecord::Migration
  def change
    create_table :blocks do |t|
      t.string :nombre
      t.float :latitud
      t.float :longitud
      t.string :descripcion
      t.integer :numSalones
      t.string :imagen

      t.timestamps null: false
    end
  end
end
