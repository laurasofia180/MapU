class CreateBlocks < ActiveRecord::Migration
  def change
    create_table :blocks do |t|
      t.integer :IdBloque
      t.integer :NoBloque
      t.integer :TotalSalon
      t.integer :TotalDependencias
      t.integer :TotalComercio

      t.timestamps null: false
    end
  end
end
