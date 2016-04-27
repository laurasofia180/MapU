class CreateDependencies < ActiveRecord::Migration
  def change
    create_table :dependencies do |t|
      t.text :Nombre

      t.timestamps null: false
    end
  end
end
